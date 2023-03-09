package com.example.javatask7;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class ProfileCreateForm {

  @NotEmpty(message = "NULL、空文字です。")
  @Length(min = 1, max = 19, message = "1~19字以内で入力してください")
  private String name;

  @NotBlank(message = "NULL、空文字もしくは空白です。")
  private String dataOfBirth;

  public ProfileCreateForm(String name, String dataOfBirth) {
    this.name = name;
    this.dataOfBirth = dataOfBirth;
  }

  public String getName() {
    return name;
  }

  public String getDataOfBirth() {
    return dataOfBirth;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDataOfBirth(String dataOfBirth) {
    this.dataOfBirth = dataOfBirth;
  }
}
