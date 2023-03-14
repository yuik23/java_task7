package com.example.javatask7;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class ProfileCreateForm {

  @NotEmpty(message = "NULLもしくは空文字です")
  @Length(min = 1, max = 19, message = "1~19字以内で入力してください")
  private String name;

  @NotEmpty(message = "NULLもしくは空文字です")
  private String dateOfBirth;

  public ProfileCreateForm(String name, String dateOfBirth) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  public String getName() {

    return name;
  }

  public String getDataOfBirth() {

    return dateOfBirth;
  }

  public void setName(String name) {

    this.name = name;
  }

  public void setDataOfBirth(String dateOfBirth) {

    this.dateOfBirth = dateOfBirth;
  }
}
