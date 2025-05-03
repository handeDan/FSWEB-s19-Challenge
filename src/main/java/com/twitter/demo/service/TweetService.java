package com.twitter.demo.service;

import com.twitter.demo.entity.Tweet;
import com.twitter.demo.entity.User;
import com.twitter.demo.repository.TweetRepository;
import com.twitter.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // business logic
public class TweetService {
  // instance variables:
  private final TweetRepository tweetRepository;
  private final UserRepository userRepository;

  // constructor:
  @Autowired
  public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
    this.tweetRepository = tweetRepository;
    this.userRepository = userRepository;
  }

  // methods:
  public Tweet createTweet(Long userId, Tweet tweet) {
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    tweet.setUser(user);
    return tweetRepository.save(tweet);
  }

  public List<Tweet> getTweetsByUserId(Long userId) {
    return tweetRepository.findByUserId(userId);
  }

  public List<Tweet> getAllTweets() {
    return tweetRepository.findAll();
  }

  public void deleteTweet(Long tweetId) {
    Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found"));
    if (tweet.getUser().getId() != null) {
      tweetRepository.delete(tweet);
    }
  }

  public Tweet updateTweet(Long tweetId, Tweet tweet) {
    Tweet existingTweet = tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found"));
    existingTweet.setContent(tweet.getContent());
    return tweetRepository.save(existingTweet);
  }
}
