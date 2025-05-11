package com.twitter.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.cors(Customizer.withDefaults()) // WebMvcConfigurer ile ayarlbu ilk tweet.adığın CORS'u kullanır
        .csrf(AbstractHttpConfigurer::disable) // CSRF kapat
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/tweet/all", "/tweet", "/tweet/add")
                    .permitAll() // herkes erişebilir
                    .anyRequest()
                    .authenticated() // diğerleri authentication ister
            )
        .build();
  }
}
