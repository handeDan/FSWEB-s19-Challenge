package com.twitter.demo.repository;

import com.twitter.demo.entity.Tweet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

  List<Tweet> findByUserId(Long userId);

  @Query("SELECT t FROM Tweet t")
  List<Tweet> findAllTweets();
}
