package com.gusrubin.springauthorizationserver.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

import com.gusrubin.springauthorizationserver.infrastructure.user.UserAccountServiceAdapter;

@EnableWebSecurity
public class DefaultSecurityConfig {

    private final UserAccountServiceAdapter userAccountService;

    private final UserDetailsService userDetailsService;

    @Autowired
    public DefaultSecurityConfig(UserAccountServiceAdapter userAccountServiceAdapter,
	    UserDetailsService userDetailsService) {
	this.userAccountService = userAccountServiceAdapter;
	this.userDetailsService = userDetailsService;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	http
	// @formatter:off
		.csrf().disable()
//		.cors().disable()
//		.headers().frameOptions().disable()
//		.and()
		.authorizeRequests(authorizeRequests -> {
                	authorizeRequests.antMatchers(
//                		"/auth/**",
                		"/oauth2/**", 
                		"/login/**", 
                		"/h2-console/**").permitAll();
//			.antMatchers("/h2-console/**").permitAll()//.hasRole("ADMIN")
//		.and()
//		.authorizeRequests(authorizeRequests ->
                	authorizeRequests.anyRequest().authenticated();
                	})
//		.anyRequest().authenticated()
		.formLogin(withDefaults());
	// @formatter:on
	return http.build();
    }

    @Bean
    AuthenticationProvider getAuthenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService);
	authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	return authenticationProvider;
    }

//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//	// ensure the passwords are encoded properly
//	UserBuilder users = User.withDefaultPasswordEncoder();
//	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	manager.createUser(users.username("user").password("password").roles("USER").build());
//	manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
//	return manager;
//    }

//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	    // @formatter:off
//	    	.antMatcher("/api/**")
//	    	.authorizeHttpRequests(authorize -> 
//	    		authorize
//	    			.anyRequest()
//	    			.hasRole("ADMIN"))
//	    	.httpBasic(org.springframework.security.config.Customizer.withDefaults());
//	    // @formatter:on	    
//	}
//    }

//    @Configuration
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	    // @formatter:off
//	    	.authorizeHttpRequests(authorize -> 
//	    		authorize
//	    			.anyRequest()
//	    			.authenticated())
//	    	.formLogin(org.springframework.security.config.Customizer.withDefaults());
//	    // @formatter:on
//	}
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    UserDetailsService users() {
//	UserDetails user = User
//     //@formatter:off
//		.withDefaultPasswordEncoder()
//		.username("admin")
//		.password("password")
//		.authorities(
//			new OidcUserAuthority(
//				new OidcIdToken(
//					"tokenValue", 
//					Instant.now(), 
//					Instant.now().plus(Duration.ofDays(1)), 
//					Collections.singletonMap("username1", "password1"))
//				)
//			)
//		.build();
////	UserDetails user = User.builder()
////		.username("user")
////		.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
////		.roles("USER")
////		.build();
////	UserDetails admin = User.builder()
////		.username("admin")
////		.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
////		.roles("USER", "ADMIN")
////		.build();
//	// @formatter:on
//	return new InMemoryUserDetailsManager(user);//, admin);
//    }

}
