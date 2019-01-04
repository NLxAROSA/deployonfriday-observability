package io.pivotal.lars.friday.observability;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.lars.friday.observability.metrics.MetricsService;

/**
 * DemoController
 */
@RestController
public class ObservabilityController {

    private final MetricsService metricsService;

    public ObservabilityController(MetricsService metricsService) throws NoSuchAlgorithmException {
        this.metricsService = metricsService;
    }

    @GetMapping
    public String addMetric(@RequestParam(required = false) Double metric) {
        if (metric == null) {
            metric = Math.random() * 50;
        }
        this.metricsService.storeMetric(metric);
        return "Metric value added: " + metric;
    }

}