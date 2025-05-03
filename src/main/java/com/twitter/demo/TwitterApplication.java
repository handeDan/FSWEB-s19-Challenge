package com.twitter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApplication {

  public static void main(String[] args) {
    SpringApplication.run(TwitterApplication.class, args);
  }

  // package yapısı:
  // com.twitter.demo
  // entity # POJO sınıfları, database tabloları(with JPA annotations)
  // service # business logic
  // repository # database işlemleri (Spring Data JPA interfaces)
  // util # yardımcı methodlar
  // controller # API endpointleri (REST controllers)
  // config # config dosyaları (SecurityConfig, WebConfig vs.)
}
