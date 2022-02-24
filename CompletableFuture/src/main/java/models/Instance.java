package models;

import java.util.ArrayList;
import java.util.List;

public class Instance {
    private String name;
    private List<Simulation> simulations = new ArrayList<>();

    public Instance(String name, List<Simulation> simulations) {
        this.name = name;
        this.simulations = simulations;
    }

    public String getName() {
        return name;
    }

    public List<Simulation> getSimulations() {
        return simulations;
    }
}
