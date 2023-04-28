package com.example.prototyp.security;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Autowired
  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  public void saveUser(User user, PasswordEncoder passwordEncoder) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    Set<Role> userRoles = new HashSet<>();
    // Assign the default role to the user
    Role defaultRole = roleRepository.findByName("USER");
    if (defaultRole != null) {
      userRoles.add(defaultRole);
    } else {
      // Create a new role if it doesn't exist in the database
      defaultRole = new Role();
      defaultRole.setName("USER");
      roleRepository.save(defaultRole);
      userRoles.add(defaultRole);
    }
    user.setRoles(userRoles);
    userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        (Collection<? extends GrantedAuthority>) user.getRoles());
  }
}
