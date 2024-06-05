package collectors;

import stream.EmployeeStream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeCollectors {
    public static void main(String[] args) {
        List<EmployeeStream<String>> employees = Arrays.asList(
                new EmployeeStream<>("Ziegfrid", 4, Arrays.asList("HEART", "FOUNDATION", "VINTAGE")),
                new EmployeeStream<>("Albert", 5, Arrays.asList("VOLUNTEER", "GREP", "FLEX")),
                new EmployeeStream<>("Alfred", 1, Arrays.asList("COE", "TEST", "GREP", "MANAGEMENT")),
                new EmployeeStream<>("Michael", 3, List.of("GREP")),
                new EmployeeStream<>("Anthony", 2, List.of("JACO")),
                new EmployeeStream<>("Jacob", 2, List.of())
        );

        System.out.println("**************************** TO COLLECTION ******************************************");
        final HashSet<EmployeeStream<String>> toCollectionExample = employees.stream()
                .filter(employee -> employee.getProjects().size() > 1)
                .collect(toCollection(HashSet::new));
        System.out.println(toCollectionExample.size());
        System.out.println("**************************** TO LIST ******************************************");
        final List<EmployeeStream<String>> toListExample = employees.stream().collect(toList());
        System.out.println(toListExample);
        System.out.println("**************************** TO UNMODIFIABLE LIST ******************************************");
        final List<EmployeeStream<String>> toUnmodifiableListExample = employees.stream().collect(toUnmodifiableList());
        System.out.println(toUnmodifiableListExample);
        System.out.println("**************************** TO SET ******************************************");
        final Set<EmployeeStream<String>> toSetExample = employees.stream().collect(toSet());
        System.out.println(toSetExample);
        System.out.println("**************************** TO UNMODIFIABLE SET ******************************************");
        final Set<EmployeeStream<String>> toUnmodifiedSetExample = employees.stream().collect(toUnmodifiableSet());
        System.out.println(toUnmodifiedSetExample);
        System.out.println("**************************** JOINING ******************************************");
        final String joiningExample = employees.stream().map(EmployeeStream::getName).collect(joining());
        System.out.println(joiningExample);
        System.out.println("**************************** JOINING ******************************************");
        final String joiningTwoExample = employees.stream().map(EmployeeStream::getName).collect(Collectors.joining(",", "", ""));
        System.out.println(joiningTwoExample);
        System.out.println("**************************** MAPPING ******************************************");
        final Set<String> mappingExample = employees.stream().collect(mapping(EmployeeStream::getName, toSet()));
        System.out.println(mappingExample);
        System.out.println("**************************** FLAT MAPPING ******************************************");
        final Map<String, Set<String>> flatMappingExample = employees.stream()
                .collect(groupingBy(EmployeeStream::getName, flatMapping(employee -> employee.getProjects().stream(), toSet())));
        System.out.println(flatMappingExample);
        System.out.println("**************************** FILTERING ******************************************");
        final Map<String, Set<EmployeeStream<String>>> filteringExample = employees.stream()
                .collect(groupingBy(EmployeeStream::getName, filtering(employee -> employee.getProjects().isEmpty(), toSet())));
        System.out.println(filteringExample);
        System.out.println("**************************** COLLECTING AND THEN ******************************************");
        employees.stream().collect(Collectors.collectingAndThen(toList(), null));
    }

    static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> supplier) {
        return Collectors.toCollection(supplier);
    }

    static <T> Collector<T, ?, List<T>> toList() {
        return Collectors.toList();
    }

    static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return Collectors.toUnmodifiableList();
    }

    static <T> Collector<T, ?, Set<T>> toSet() {
        return Collectors.toSet();
    }

    static <T> Collector<T, ?, Set<T>> toUnmodifiableSet() {
        return Collectors.toUnmodifiableSet();
    }

    static Collector<CharSequence, ?, String> joining() {
        return Collectors.joining();
    }

    static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> function, Collector<? super U, A, R> downstream) {
        return Collectors.mapping(function, downstream);
    }

    static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> mapper, Collector<? super T, A, D> downstream) {
        return Collectors.groupingBy(mapper, downstream);
    }

    static <T, U, A, R> Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream) {
        return Collectors.flatMapping(mapper, downstream);
    }

    static <T, R> Collector<T, ?, R> filtering(Predicate<T> predicate, Collector<T, ?, R> downstream) {
        return Collectors.filtering(predicate, downstream);
    }
}