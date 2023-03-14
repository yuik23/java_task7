package com.example.javatask7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProfileController {
  @GetMapping("/profiles")
  public List<String> getProfiles() {

    return List.of("tanaka", "suzuki");
  }

  @PostMapping("/profiles")
  public ResponseEntity<String> create(@RequestBody @Validated ProfileCreateForm form, UriComponentsBuilder uriComponentsBuilder) {
    // 登録処理は 省略
    URI url = uriComponentsBuilder
                      .path("/profiles/id") // id部分は 実際に 登録された際に発⾏したidを 設定する
                      .query("name=Isono")
                      .build()
                      .toUri();
    return ResponseEntity.created(url).body("profile successfully created");
  }

  @PatchMapping("/profiles/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated ProfileUpdateForm form) {
    // 更新処理は 省略
    return ResponseEntity.ok(Map.of("message", "profile successfully updated"));
  }

  @DeleteMapping("/profiles/{id}")
  public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
    return ResponseEntity.ok(Map.of("message", "profile successfully deleted"));
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
          MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

}

