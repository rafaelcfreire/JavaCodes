package generics.toMap;

import generics.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class ToMapEmployee {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alfred", 1),
                new Employee("Ziegfrid", 4),
                new Employee("Albert", 5),
                new Employee("Michael", 3)
        );

        Map<Integer, Employee> employeeMap = employees.stream().collect(toMap(Employee::getId, Function.identity()));
    }
}
