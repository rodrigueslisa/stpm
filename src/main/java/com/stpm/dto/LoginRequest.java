package com.stpm.dto;
import jakarta.validation.constraints.*;

public class LoginRequest {
  @Email @NotBlank private String email;
  @NotBlank private String password;
  
  public LoginRequest() {
  }

  public LoginRequest(String email, String password) {
      this.email = email;
      this.password = password;
  }

  public String getEmail() {
      return email;
  }

  public String getPassword() {
      return password;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public void setPassword(String password) {
      this.password = password;
  }
}