package models;

import java.util.ArrayList;
import java.util.List;

public class Avatar {
    public String name;
    public Long id;
    List<Instance> instances = new ArrayList<>();

    public Avatar(String name, List<Instance> instances) {
        this.name = name;
        this.instances = instances;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Instance> getInstances() {
        return instances;
    }
}
