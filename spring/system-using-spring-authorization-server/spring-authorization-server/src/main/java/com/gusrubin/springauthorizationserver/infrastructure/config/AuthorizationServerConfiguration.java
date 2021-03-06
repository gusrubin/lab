package com.gusrubin.springauthorizationserver.infrastructure.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

//@Configuration
//@Import(OAuth2AuthorizationServerConfiguration.class)
@EnableWebSecurity
@Import(OAuth2AuthorizationServerConfiguration.class)
//@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
	OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
	return http.formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
	RegisteredClient gatewayClient = RegisteredClient
	// @formatter:off
		.withId(UUID.randomUUID().toString())
		.clientId("gateway-client")
		.clientSecret("gatewaysecret")
		.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
		.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
		.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//		.redirectUri("http://api-gateway:4000/oauth2/token")
		.redirectUri("http://127.0.0.1:3005/call-back-a")
//		.redirectUri("http://127.0.0.1:3003")
//		.redirectUri("http://api-gateway:4000/authorized")
		.redirectUri("http://127.0.0.1:3005/call-back-b")
//		.redirectUri("http://127.0.0.1:3005/")
		.scope(OidcScopes.OPENID)
		.scope(OidcScopes.EMAIL)
//		.scope("message.read")
//		.scope("message.write")
//		.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
		.build();
	// @formatter:on

	RegisteredClient exampleClient = RegisteredClient
	// @formatter:off
		.withId(UUID.randomUUID().toString())
		.clientId("example-client")
		.clientSecret("{noop}secretexample")
		.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
		.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
		.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
		.redirectUri("http://127.0.0.1:9001/login/oauth2/code/example-client-oidc")
//		.redirectUri("http://127.0.0.1:3003")
		.redirectUri("http://127.0.0.1:9001/authorized")
//		.redirectUri("http://127.0.0.1:3005/")
		.scope(OidcScopes.OPENID)
		.scope("message.read")
		.scope("message.write")
//		.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
		.build();
	// @formatter:on

	RegisteredClient angularAppClient = RegisteredClient
	// @formatter:off
		.withId(UUID.randomUUID().toString())
//		.id("angular-app")
//		.clientName("angular")
		.clientId("angular-app-client")
		.clientSecret("angularsecret")
		.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
		.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
		.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//		.redirectUri("http://ui-service:4200/login/oauth2/code")
		.redirectUri("http://ui-service:4200/login/oauth2/code")
		.redirectUri("http://ui-service:4200/oauth2/authorized")
//		.redirectUri("http://ui-service:4200/oauth2/authorized")
		.scope(OidcScopes.OPENID)
//		.scope("message.read")
//		.scope("message.write")
//		.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
		.build();
	// @formatter:on
	return new InMemoryRegisteredClientRepository(gatewayClient, exampleClient, angularAppClient);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
	RSAKey rsaKey = generateRsa();
	JWKSet jwkSet = new JWKSet(rsaKey);
	return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    private static RSAKey generateRsa() throws NoSuchAlgorithmException {
	KeyPair keyPair = generateRsaKey();
	RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
	RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
	return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
    }

    private static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	keyPairGenerator.initialize(2048);
	return keyPairGenerator.generateKeyPair();
    }

    @Bean
    public ProviderSettings providerSettings() {
	return ProviderSettings.builder().issuer("http://auth-service:9001").build();
    }

    @Bean
    public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate,
	    RegisteredClientRepository registeredClientRepository) {
	return new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
    }

    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(JdbcTemplate jdbcTemplate,
	    RegisteredClientRepository registeredClientRepository) {
	return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
    }

    @Bean
    public EmbeddedDatabase embeddedDatabase() {
	return new EmbeddedDatabaseBuilder()
	// @formatter:off
		.generateUniqueName(true)
		.setType(EmbeddedDatabaseType.H2)
		.setScriptEncoding("UTF-8")
		.addScript("org/springframework/security/oauth2/server/authorization/oauth2-authorization-schema.sql")
		.addScript("org/springframework/security/oauth2/server/authorization/oauth2-authorization-consent-schema.sql")
		.addScript("org/springframework/security/oauth2/server/authorization/client/oauth2-registered-client-schema.sql")
		.build();
	// @formatter:on
    }

}
