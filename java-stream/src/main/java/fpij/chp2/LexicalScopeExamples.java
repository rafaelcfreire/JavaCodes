package fpij.chp2;

import java.util.function.Function;
import java.util.function.Predicate;

import static fpij.chp2.CollectionsSupplier.*;

final class LexicalScopeExamples {
    public static void main(String[] args) {
        System.out.println("**********************************PREDICATES EXAMPLES************************************");
        FRIENDS.stream().filter(nameStartsWithPrefix.apply("B")).forEach(System.out::println);
        EDITORS.stream().filter(nameStartsWithPrefix.apply("J")).forEach(System.out::println);
        COMRADES.stream().filter(nameStartsWithPrefix.apply("K")).forEach(System.out::println);
        System.out.println("**********************************FUNCTION EXAMPLES************************************");
        FRIENDS.stream().map(convertNameToUpperCase).forEach(System.out::println);
        EDITORS.stream().map(convertNameToUpperCase).forEach(System.out::println);
        COMRADES.stream().map(convertNameToUpperCase).forEach(System.out::println);
        System.out.println("**********************************CONSUMER EXAMPLES************************************");
        FRIENDS.stream().map(convertNameToUpperCase).forEach(System.out::println);
        EDITORS.stream().map(convertNameToUpperCase).forEach(System.out::println);
        COMRADES.stream().map(convertNameToUpperCase).forEach(System.out::println);


    }
    private static final Function<String, Predicate<String>> nameStartsWithPrefix = prefix -> name -> name.startsWith(prefix);
    private static final Function<String, String> convertNameToUpperCase = content -> content.toUpperCase();

}