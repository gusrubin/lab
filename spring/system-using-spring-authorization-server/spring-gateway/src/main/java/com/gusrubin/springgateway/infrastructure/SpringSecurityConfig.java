package com.gusrubin.springgateway.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebFluxSecurity
public class SpringSecurityConfig {

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {	
	// @formatter:off
	http.authorizeExchange(exchanges -> exchanges                
		.pathMatchers("/api/**", "/portal/**").authenticated()
		.anyExchange().permitAll()
		.and().oauth2Login()
//		.and().oauth2Client()	
//		.and().formLogin()
	);
        // @formatter:on
	return http.build();
    }

}
