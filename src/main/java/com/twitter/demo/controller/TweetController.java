package com.twitter.demo.controller;

import com.twitter.demo.dto.TweetCreateRequest;
import com.twitter.demo.dto.TweetDto;
import com.twitter.demo.entity.Tweet;
import com.twitter.demo.service.TweetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  // for test:
  @GetMapping("/all")
  public List<TweetDto> getAllTweetList() {
    List<Tweet> count = tweetService.getAllTweets();
    System.out.println("count.++ " + count.toString());
    return tweetService.getAllTweets().stream()
        .map(
            tweet ->
                new TweetDto(
                    tweet.getId(),
                    tweet.getContent(),
                    tweet.getCreatedAt().toString(),
                    tweet.getUser().getId(),
                    tweet.getUser().getUsername()))
        .toList();
  }

  @PostMapping("/add")
  public Tweet createTweet(@RequestBody TweetCreateRequest request) {
    System.out.println("2: " + request.getText());

    return tweetService.createTweet(request.getUser(), request.getText());
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
