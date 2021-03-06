package com.example.defaultauthorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http
		// @formatter:off
				.authorizeRequests(authorizeRequests ->
					authorizeRequests.anyRequest().authenticated()
						)
				.formLogin(withDefaults());
		// @formatter:on
		return http.build();
	}

	@Bean
	UserDetailsService users() {
		UserDetails user = User
		// @formatter:off
				.withDefaultPasswordEncoder()
				.username("user1")
				.password("password")
				.roles("USER")
				.build();
		// @formatter:on
		return new InMemoryUserDetailsManager(user);
	}

}
