package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableCaching
public class SpringDataRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisCacheApplication.class, args);
	}

	@Bean
	SecurityFilterChain security(HttpSecurity http) {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/public/**").permitAll()
						.anyRequest().authenticated()
				)
				.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()))
				.build();
	}
}
