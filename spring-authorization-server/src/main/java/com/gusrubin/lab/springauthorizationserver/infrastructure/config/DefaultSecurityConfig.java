/**
 * 
 */
package com.gusrubin.lab.springauthorizationserver.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Gustavo Rubin
 *
 */
@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	// @formatter:off
	http.authorizeHttpRequests(authorize -> 
		authorize.anyRequest().authenticated()).formLogin(withDefaults());
	// @formatter:on
	return http.build();
    }

    @Bean
    UserDetailsService users() {
	UserDetails user = User.withDefaultPasswordEncoder()
	// @formatter:off
		.username("user1")
		.password("password")
		.roles("USER")
		.build();
	// @formatter:on
	return new InMemoryUserDetailsManager(user);
    }

}