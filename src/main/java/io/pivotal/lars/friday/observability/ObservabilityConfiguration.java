package io.pivotal.lars.friday.observability;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ObservabilityConfiguration
 */
@Configuration
public class ObservabilityConfiguration {

    @Bean
    public RestTemplate restTemplate()  {
        return new RestTemplate();
    }
    
}