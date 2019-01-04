package io.pivotal.lars.friday.observability.metrics;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Instance
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instance {

    String id = System.getenv("CF_INSTANCE_GUID");
    String index = System.getenv("CF_INSTANCE_INDEX");
    List<Metric> metrics = new ArrayList<>();
    
    public void addMetric(Metric metric)    {
        this.metrics.add(metric);
    }
    
}