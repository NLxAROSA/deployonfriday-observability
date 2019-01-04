package io.pivotal.lars.friday.observability.metrics;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Application
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private String id;
    private List<Instance> instances = new ArrayList<>();
    
    public void addInstance(Instance instance)  {
        instances.add(instance);
    }
}