package mjic.chp3;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Exercising the 3 different ways to use method reference
 * 1 - Static method from another class
 * 2 - method on an object passed to the lambda
 * 3 - method on an object on the scope surrounding the lambda
 */
final class MethodReferenceExamples {

    static boolean methodOne(String string) {
        return string.isEmpty();
    }

    public static void main(String[] args) {
        //Static Method
        List<String> strings = List.of("One", "Two", "Three", "Four");
        List<String> listOne = strings.stream().filter(MethodReferenceExamples::methodOne).toList();

        //Method on an object passed to the lambda
        List<Integer> listTwo = strings.stream().map(String::length).toList();

        //Method on an object on the scope surrounding the lambda
        Foo foo = new Foo();
        List<Integer> listThree = strings.stream().map(foo::getCurrentValue).toList();

        //Constructor Reference
        Supplier<Foo> fooSupplier = Foo::new;
        Foo fooRetreivedFromSupplier = fooSupplier.get();
    }

    static class Foo {
        int getCurrentValue(String value) {
            return (int)(Math.random() * value.length());
        }
    }
}