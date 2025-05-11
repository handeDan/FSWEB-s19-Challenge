package com.twitter.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tweets", schema = "tw")
public class Tweet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content")
  @NotBlank(message = "Content is required")
  private String content;

  @Column(name = "createdAt")
  private LocalDateTime createdAt = LocalDateTime.now();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Override
  public String toString() {
    return "Tweet{"
        + "id="
        + id
        + ", content='"
        + content
        + '\''
        + ", createdAt="
        + createdAt
        + ", userId="
        + (user != null ? user.getId() : null)
        + '}';
  }
}
