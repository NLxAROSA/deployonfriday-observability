package io.pivotal.lars.friday.observability.metrics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApplicationConfiguration
 */
@Configuration
@ConfigurationProperties("vcap.application")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationConfiguration {

    private String applicationName;
    private String applicationId;
    
}