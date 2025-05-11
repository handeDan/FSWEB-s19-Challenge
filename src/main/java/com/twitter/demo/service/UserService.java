package com.twitter.demo.service;

import com.twitter.demo.entity.User;
import com.twitter.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  //  private final PasswordEncoder passwordEncoder;

  // constructor:
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  //  public User registerUser(User user) {
  //    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
  //      throw new RuntimeException("Email already exists");
  //    }
  //    user.setPassword(passwordEncoder.encode(user.getPassword()));
  //    return userRepository.save(user);
  //  }

  //  public User login(String email, String password) {
  //    User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
  //    if (!passwordEncoder.matches(password, user.getPassword())) {
  //      throw new RuntimeException("Invalid password");
  //    }
  //    return user;
  //  }

  public User getById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }
}
