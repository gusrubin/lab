package com.gusrubin.lab.javafxwithspring.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author Gustavo Rubin
 */
@ConfigurationProperties(prefix = "app.external-service")
@Validated
public record ExternalServiceProperties(String baseUrl) {}
