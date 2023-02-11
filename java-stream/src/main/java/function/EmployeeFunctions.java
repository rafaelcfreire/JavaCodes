package function;

import stream.EmployeeStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class EmployeeFunctions {
    public static void main(String[] args) {
        List<EmployeeStream<String>> employees = Arrays.asList(
                new EmployeeStream<>("Ziegfrid", 4, Arrays.asList("HEART", "FOUNDATION", "VINTAGE")),
                new EmployeeStream<>("Albert", 5, Arrays.asList("VOLUNTEER", "GREP", "FLEX")),
                new EmployeeStream("Alfred", 1, Arrays.asList("COE", "TEST", "GREP", "MANAGEMENT")),
                new EmployeeStream<>("Michael", 3, Arrays.asList("GREP")),
                new EmployeeStream("Anthony", 2, Arrays.asList("JACO"))
        );

        System.out.println("************************* BI CONSUMER *********************************************");
        BiConsumer<EmployeeStream, EmployeeStream> biConsumer = (x, y) -> System.out.println(x.getName() +"|"+ y.getName());
        biConsumer.accept(employees.get(0), employees.get(1));
        System.out.println("************************* BI FUNCTION *********************************************");
        BiFunction<EmployeeStream, EmployeeStream, String> biFunction = (x, y) -> x.getName()+" || "+y.getName();
        System.out.println(biFunction.apply(employees.get(0), employees.get(1)));
        System.out.println("************************* BI OPERATOR *********************************************");
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(employees.get(3).getId(), employees.get(4).getId()));
        System.out.println("************************* BI CONSUMER *********************************************");
        BiPredicate<EmployeeStream, EmployeeStream> biPredicate = (x, y) -> x.getId() > y.getId();
        System.out.println(biPredicate.test(employees.get(0), employees.get(1)));
        System.out.println("************************* CONSUMER *********************************************");
        Consumer<EmployeeStream> consumer = x -> System.out.println(x.getName());
        employees.forEach(consumer.andThen(x -> System.out.println(x.getId())));
        System.out.println("************************* DOUBLE BINARY OPERATOR *********************************************");
        DoubleBinaryOperator doubleBinaryOperator = (x, y) -> x * y;
        System.out.println(doubleBinaryOperator.applyAsDouble(employees.get(0).getId(), employees.get(1).getId()));
        System.out.println("************************* DOUBLE CONSUMER *********************************************");
        DoubleConsumer doubleConsumer = x -> System.out.println(" x = "+x);
        DoubleConsumer then = x -> System.out.println("X^2 = "+x*x);
        DoubleConsumer composite = doubleConsumer.andThen(then);
        composite.accept(3);
        System.out.println("************************* FUNCTION *********************************************");
        Function<EmployeeStream<String>, Integer> function = x -> x.getId();
        employees.stream().map(function).forEach(System.out::println);
        System.out.println("************************* PREDICATE *********************************************");
        Predicate<EmployeeStream<String>> predicate = x -> x.getName().equals("Alfred");
        System.out.println(employees.stream().filter(predicate).count());
        System.out.println("************************* SUPPLIER *********************************************");
        Supplier<EmployeeStream<String>> supplier = () -> employees.get(0);
        System.out.println(supplier.get());
    }
}
