package com.example.prototyp.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "users")
public class User {

  @Id
  private Long id;

  private String username;
  private String password;
  // Add other fields if necessary (email, firstName, lastName, etc.)
  // Add getters and setters

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
