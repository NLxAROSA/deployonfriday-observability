package io.pivotal.lars.friday.observability.metrics;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.lars.friday.observability.metrics.MetricsConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * MetricsService
 */
@Service
@Slf4j
public class MetricsService {

    private final ApplicationConfiguration applicationConfiguration;
    private final MetricsConfiguration metricsConfiguration;
    private final RestTemplate restTemplate;

    public MetricsService(ApplicationConfiguration applicationConfiguration, MetricsConfiguration demoConfiguration, RestTemplate restTemplate) {
        this.applicationConfiguration = applicationConfiguration;
        this.metricsConfiguration = demoConfiguration;
        this.restTemplate = restTemplate;
    }

    public void storeMetric(double metricValue) {
        String uri = metricsConfiguration.getEndpoint();
        String accessKey = metricsConfiguration.getAccessKey();        

        HttpEntity<CustomMetrics> requestEntity = new HttpEntity<CustomMetrics>(generateMetrics(metricValue), createHeaders(accessKey));
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
        log.info("Metrics forwarder API responded with status code {}", response.getStatusCodeValue());
    }

    private HttpHeaders createHeaders(String accessKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessKey);
        return headers;
    }

    private CustomMetrics generateMetrics(double value)    {
        CustomMetrics customMetrics = new CustomMetrics();
        Application application = new Application();
        application.setId(applicationConfiguration.getApplicationId());
        Instance instance = new Instance();
        Metric metric = new Metric();
        metric.value = value;
        instance.addMetric(metric);
        application.addInstance(instance);
        customMetrics.addApplication(application);
        return customMetrics;
    }
}