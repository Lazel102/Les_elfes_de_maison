package com.example.prototyp.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain configure (HttpSecurity chainBuilder) throws Exception{
    chainBuilder.authorizeHttpRequests(
        configurer -> configurer.antMatchers("/").permitAll()
            .anyRequest().authenticated()
    ).formLogin();
    return chainBuilder.build();
  }
  @Bean
  public UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(new User("Yannick","{noop}password", List.of()));
    manager.createUser(new User("Yassine","{noop}password", List.of()));
    return manager;
  }

}
