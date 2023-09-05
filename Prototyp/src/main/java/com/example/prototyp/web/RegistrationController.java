package com.example.prototyp.web;

import com.example.prototyp.security.User;
import com.example.prototyp.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;


  public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }


  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User(null,null,null));
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute("user") User user) {
    userService.saveUser(user,passwordEncoder);
    return "redirect:";
  }
}