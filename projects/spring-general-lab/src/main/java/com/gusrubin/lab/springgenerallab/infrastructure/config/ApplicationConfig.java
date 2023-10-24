package com.gusrubin.lab.springgenerallab.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Gustavo Rubin
 *
 */
@Configuration
@EnableScheduling
//@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = "com.gusrubin.lab.springgenerallab.infrastructure.database")
public class ApplicationConfig {

	@Bean
	ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
