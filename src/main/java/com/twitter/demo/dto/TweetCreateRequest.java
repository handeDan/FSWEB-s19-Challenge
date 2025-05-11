package com.twitter.demo.dto;

import lombok.Data;

@Data
public class TweetCreateRequest {
  private String user;
  private String text;
}
