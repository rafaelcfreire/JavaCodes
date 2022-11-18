package generics.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

final class MaxEmployee {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alfred", 1),
                new Employee("Ziegfrid", 4),
                new Employee("Albert", 5),
                new Employee("Michael", 3)
        );

        Employee maxId = employees.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getId() - o2.getId();
            }
        }).orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxName = employees.stream().max(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        }).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId.getName());
        System.out.println(maxName.getName());

        Employee maxIdLambda = employees.stream().max((Employee e1, Employee e2) -> e1.getId() - e2.getId()).orElse(Employee.DEFAULT_EMPLOYEE);
        Employee maxNameLambda = employees.stream().max((Object o1, Object o2) -> o1.toString().compareTo(o2.toString())).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxIdLambda.getName());
        System.out.println(maxNameLambda.getName());

        Employee maxIdComparing = employees.stream().max(comparing(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
        Employee maxNameComparing = employees.stream().max(comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxIdComparing.getName());
        System.out.println(maxNameComparing.getName());
    }
}
