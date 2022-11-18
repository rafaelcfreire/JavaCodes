package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperations {
    public static void main(String[] args) {
        List<EmployeeStream> employees = Arrays.asList(
                new EmployeeStream("Alfred", 1, Arrays.asList("COE", "TEST", "GREP", "MANAGEMENT")),
                new EmployeeStream<>("Ziegfrid", 4, Arrays.asList("HEART", "FOUNDATION", "VINTAGE")),
                new EmployeeStream<>("Albert", 5, Arrays.asList("VOLUNTEER", "GREP", "FLEX")),
                new EmployeeStream<>("Michael", 3, Arrays.asList("GREP"))
        );

        employees.stream().filter(e -> e.getName().contains("A")).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().map(e -> e.getId() + "-" + e.getName()).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().mapToInt(EmployeeStream::getId).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().flatMap(e -> e.getProjects().stream()).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().flatMapToInt(e -> IntStream.of(e.getId())).forEach(System.out::println);
        System.out.println("**********************************************************************");
        System.out.println(employees.stream().distinct().count());
        System.out.println("**********************************************************************");
        employees.stream().sorted((e1, e2) -> e1.getId() - e2.getId()).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream()
                .filter(e -> e.getId() == 3).peek(e -> System.out.println("Filtered value: "+e))
                .map(e -> e.getName().toUpperCase())
                .peek(e -> System.out.println("Mapped Value: "+e))
                .collect(Collectors.toList());
        System.out.println("**********************************************************************");
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("**********************************************************************");
        employees.stream().takeWhile(e -> e.getName().startsWith("A")).forEach(System.out::println);
    }
}