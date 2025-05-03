package com.twitter.demo.controller;

import com.twitter.demo.entity.User;
import com.twitter.demo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
  private final UserService userService;

  // constructor:
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // API endpoints:
  @PostMapping("/register")
  public User registerUser(@RequestBody User user) {
    return userService.registerUser(user);
  }

  @PostMapping("/login")
  public User loginUser(@RequestBody LoginRequest request) {
    return userService.login(request.getEmail(), request.getPassword());
  }

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable Long id) {
    return userService.getById(id);
  }

  @Data
  public static class LoginRequest {
    private String email;
    private String password;
  }
}
