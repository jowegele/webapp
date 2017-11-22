package com.jowegele.webapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JWG 2017-11-22
 */

@Configuration
@EnableJpaRepositories("com.jowegele.webapp.repositories.")
public class JpaConfig {
}
