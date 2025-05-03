package com.twitter.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "User", schema = "tw")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  @NotBlank(message = "Username is required")
  private String username;

  @Column(name = "email")
  @NotBlank(message = "Email is required")
  private String email;

  @Column(name = "password")
  @NotBlank(message = "Password is required")
  private String password;

  @Column(name = "createdAt")
  private String createdAt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Tweet> tweets;
}
