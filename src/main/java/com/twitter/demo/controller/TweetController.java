package com.twitter.demo.controller;

import com.twitter.demo.entity.Tweet;
import com.twitter.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {
  // instance variables:
  private final TweetService tweetService;

  // constructor:
  @Autowired
  public TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @PostMapping
  public Tweet createTweet(@RequestParam Long userId, @RequestBody Tweet tweet) {
    return tweetService.createTweet(userId, tweet);
  }

  @GetMapping("/findByUserId")
  public List<Tweet> getTweetsByUserId(@RequestParam Long userId) {
    return tweetService.getTweetsByUserId(userId);
  }

  @GetMapping("/findById")
  public Tweet getTweetById(@RequestParam Long id) {
    return tweetService.getTweetById(id);
  }

  @PutMapping("/{id}")
  public Tweet updateTweet(@PathVariable Long id, @RequestBody Tweet tweet) {
    return tweetService.updateTweet(id, tweet);
  }

  @DeleteMapping("/{id}")
  public void deleteTweet(@PathVariable Long id) {
    tweetService.deleteTweet(id);
  }

}
