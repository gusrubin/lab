/**
 * 
 */
package com.gusrubin.lab.cleanlog.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Gustavo Rubin
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.gusrubin.lab.cleanlog.infrastructure.database")
public class ApplicationConfig {

    @Bean
    ModelMapper getModelMapper() {
	ModelMapper modelMapper = new ModelMapper();
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	return modelMapper;
    }

}
