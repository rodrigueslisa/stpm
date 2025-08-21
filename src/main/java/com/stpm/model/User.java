package com.stpm.model;

import jakarta.persistence.*;

@Entity @Table(name="users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable=false,length=100)
  private String name;

  @Column(nullable=false, unique=true, length=100)
  private String email;

  @Column(nullable=false,length=255)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false,length=20)
  private Role role;
  
  public User() {}

  public User(Integer id, String name, String email, String password, Role role) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.password = password;
      this.role = role;
  }

  
  public Integer getId() {
      return id;
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

  public void setId(Integer id) {
      this.id = id;
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