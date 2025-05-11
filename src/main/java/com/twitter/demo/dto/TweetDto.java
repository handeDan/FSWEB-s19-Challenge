package com.twitter.demo.dto;

// TweetDto.java
public record TweetDto(Long id, String content, String createdAt, Long userId, String username) {}
