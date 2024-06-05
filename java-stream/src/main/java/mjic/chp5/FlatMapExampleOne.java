package mjic.chp5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

//Example taken from Modern Java in Action, section 5.3.2
// Here we are trying to get a stream of characters instead of a stream of arrays
final class FlatMapExampleOne {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World");

        //Endps up having Stream<String[]>
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        //Ends up having Stream<Stream<String>>>
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
    }
}