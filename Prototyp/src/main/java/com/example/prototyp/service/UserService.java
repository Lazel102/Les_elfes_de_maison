package com.example.prototyp.service;

import com.example.prototyp.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  public void saveUser(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(encodedPassword)
        .roles("USER") // Or any other default role you want to assign
        .build();
    ((InMemoryUserDetailsManager) userDetailsService).createUser(userDetails);
  }
}