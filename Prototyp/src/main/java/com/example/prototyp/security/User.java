package com.example.prototyp.security;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;

@Table("users")
public record User(@Id Long id, String username, String password) implements GrantedAuthority {

  @Override
  public String getAuthority() {
    return "USER"; // You can provide the appropriate authority string here
  }



}