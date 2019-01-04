package io.pivotal.lars.friday.observability.metrics;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MetricsRequest
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomMetrics {
    
    private List<Application> applications = new ArrayList<>();
    
    public void addApplication(Application application) {
        this.applications.add(application);
    }
}