package com.stpm.dto;

import com.stpm.model.Role;
import jakarta.validation.constraints.*;

public class SignupRequest {
  @NotBlank private String name;
  @Email @NotBlank private String email;
  @Size(min=6) private String password;
  @NotNull private Role role;
  
  public SignupRequest() {
  }

  public SignupRequest(String name, String email, String password, Role role) {
      this.name = name;
      this.email = email;
      this.password = password;
      this.role = role;
  }

  public String getName() {
      return name;
  }

  public String getEmail() {
      return email;
  }

  public String getPassword() {
      return password;
  }

  public Role getRole() {
      return role;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public void setRole(Role role) {
      this.role = role;
  }
}