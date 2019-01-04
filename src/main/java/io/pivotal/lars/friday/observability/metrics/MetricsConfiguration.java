package io.pivotal.lars.friday.observability.metrics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DemoConfiguration
 */
@Configuration
@ConfigurationProperties("vcap.services.my-metrics-forwarder.credentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsConfiguration {

    private String accessKey;
    private String endpoint;
    
}