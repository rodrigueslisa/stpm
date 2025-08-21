package com.stpm.controller;

import com.stpm.dto.LoginRequest;
import com.stpm.dto.SignupRequest;
import com.stpm.model.User;
import com.stpm.dto.UserResponse;
import com.stpm.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService auth;

  public AuthController(AuthService auth) {
    this.auth = auth;
  }

  @PostMapping("/signup")
  public ResponseEntity<UserResponse> signup(@Valid @RequestBody SignupRequest req) {
      User saved = auth.signup(req);

      UserResponse response = new UserResponse(
          saved.getId(),
          saved.getName(),
          saved.getEmail(),
          saved.getRole()
      );
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
      try {
          User user = auth.login(req);

          UserResponse response = new UserResponse(
              user.getId(),
              user.getName(),
              user.getEmail(),
              user.getRole()
          );

          return ResponseEntity.ok(response);

      } catch (IllegalArgumentException ex) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
      }
  }
}