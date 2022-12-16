package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<EmployeeStream> employees = Arrays.asList(
                new EmployeeStream<>("Ziegfrid", 4, Arrays.asList("HEART", "FOUNDATION", "VINTAGE")),
                new EmployeeStream<>("Albert", 5, Arrays.asList("VOLUNTEER", "GREP", "FLEX")),
                new EmployeeStream("Alfred", 1, Arrays.asList("COE", "TEST", "GREP", "MANAGEMENT")),
                new EmployeeStream<>("Michael", 3, Arrays.asList("GREP")),
                new EmployeeStream("Anthony", 2, Arrays.asList("JACO"))
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
                .peek(e -> System.out.println("Mapped Value: "+e));
        System.out.println("***************************** LIMIT *****************************************");
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("***************************** SKIP *****************************************");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("**************************** TAKE WHILE ******************************************");
        employees.stream().sorted().takeWhile(e -> e.getName().startsWith("Alb")).forEach(System.out::println);
        employees.stream().sorted().takeWhile(e -> e.getName().startsWith("Alf")).forEach(System.out::println);
        System.out.println("**************************** DROP WHILE******************************************");
        employees.stream().sorted().dropWhile(e -> e.getName().startsWith("Al")).forEach(System.out::println);
        System.out.println("**************************** FOR EACH ORDERED ******************************************");
        employees.parallelStream().forEach(System.out::println);
        System.out.println("    ********** PARALLEL *********");
        employees.parallelStream().forEachOrdered(System.out::println);
        System.out.println("**************************** REDUCE ******************************************");
        System.out.println(Stream.of(1,2,3,4,5,6,7,8,9).reduce(1, (a, b) -> a * b));
        System.out.println("**************************** REDUCE ******************************************");
        System.out.println(Stream.of(1,2,3,4,5,6,7,8,9).reduce((a, b) -> a * b).orElse(51));
        System.out.println("**************************** REDUCE WITH BINARY OPERATOR ***********************");
        System.out.println(Stream.of(1,2,3,4,5,6,7,8,9).parallel().reduce(1, (a, b) -> a * b, (a, b) -> a * b));
        System.out.println("**************************** COLLECT ******************************************");
        employees.parallelStream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll).forEach(System.out::println);
    }
}