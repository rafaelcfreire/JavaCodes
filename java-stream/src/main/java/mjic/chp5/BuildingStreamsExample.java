package mjic.chp5;

import java.util.Arrays;
import java.util.stream.Stream;

final class BuildingStreamsExample {
    public static void main(String[] args) {
        //From values
        Stream<String> stream = Stream.of("Modern", "Java", "In", "action");

        //From nullable
        String homeValue = System.getProperty("home");
        Stream<String> streamOfNullable = Stream.ofNullable(homeValue);

        //From Arrays
        int[] numbers = {2, 3, 4, 5, 6, 7};
        int sum = Arrays.stream(numbers).sum();

        //From functions (infinite streams)
        Stream.iterate(0, n -> n + 2)
                .limit(1_000_000)
                .forEach(System.out::println);
    }
}