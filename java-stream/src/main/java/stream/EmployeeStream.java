package stream;

import java.util.Arrays;
import java.util.List;

public final class EmployeeStream<T> implements Comparable<EmployeeStream> {
    public static final EmployeeStream DEFAULT_EMPLOYEE = new EmployeeStream("Default", 0, Arrays.asList("Default"));
    private final String name;
    private final int id;
    private List<T> projects;
    public EmployeeStream(String name, int id, List<T> projects) {
        this.name = name;
        this.id = id;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<T> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(EmployeeStream o) {
        return this.getName().compareTo(o.getName());
    }
}
