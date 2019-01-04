package io.pivotal.lars.friday.observability.metrics;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Metric
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metric {

    String name = "lars.metrics.oranges";
    String type = "gauge";
    double value;
    long timestamp = System.currentTimeMillis();
    String unit = "oranges";
    Map<String, String> tags = new HashMap<>();
    
}