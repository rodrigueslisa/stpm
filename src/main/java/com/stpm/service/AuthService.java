package com.stpm.service;

import com.stpm.dto.LoginRequest;
import com.stpm.dto.SignupRequest;
import com.stpm.model.User;
import com.stpm.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
  private final UserRepository users;

  public AuthService(UserRepository users) {
    this.users = users;
  }

  @Transactional
  public User signup(SignupRequest req) {
      if (users.existsByEmail(req.getEmail())) {
          throw new IllegalArgumentException("Email already in use");
      }

      User u = new User();
      u.setName(req.getName());
      u.setEmail(req.getEmail());
      u.setPassword(req.getPassword());
      u.setRole(req.getRole());

      return users.save(u);

  }
  
  @Transactional(readOnly = true)
  public User login(LoginRequest req) {
      User u = users.findByEmail(req.getEmail())
              .orElseThrow(() -> new IllegalArgumentException("User not found"));

      if (!u.getPassword().equals(req.getPassword())) { // ⚠️ use password hashing later
          throw new IllegalArgumentException("Invalid password");
      }

      return u;
  }
}