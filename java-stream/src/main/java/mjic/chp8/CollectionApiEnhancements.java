package mjic.chp8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

final class CollectionApiEnhancements {
    public static void main(String[] args) {
        //fixed-sized list backed by an array, cannot add elements but can change. All changes affect also the array.
        String[] array = new String[]{"a", "b"};
        List<String> friends = Arrays.asList(array);
        friends.set(0, "c");

        //List Factory
        List<String> friendsTwo = List.of("a", "b");

        //Map forEach -> new in Java 8
        Map<String, Integer> ageOfFriends = Map.of("a1", 35, "b1", 43, "c1", 55);
        ageOfFriends.forEach((friend, age) -> System.out.println(friend+" is "+age+" years old"));
        //getOrDefault
        ageOfFriends.getOrDefault("James", 32);

        //compute patterns
        //If there's no specified value for the given key, calculate a new value by using the key and add it to the Map
        Map<String, Integer> mutableMap = new HashMap<>(ageOfFriends);
        Function<String, Integer> function = (name) -> {
            System.out.println("executed something");
            return -1;
        };
        System.out.println(mutableMap.computeIfAbsent("a1", function));

        //If the specified key is present, calculate a new value for it and add it to the Map
        BiFunction<String, Integer, Integer> biFunction = (name, age) -> {
            System.out.println("Executed BiFunction");
            return age;
        };
        mutableMap.computeIfPresent("temp", biFunction);

        //This operation calculates a new value for a given key and stores it in the Map.
        BiFunction<String, Integer, Integer> agePlusLength = (name, age) -> {
            System.out.println("Calculating new age with length");
            return age + name.length();
        };
        System.out.println(mutableMap.compute("a1", agePlusLength));

        Map<String, List<String>> friendsToMove = new HashMap<>();
        friendsToMove.computeIfAbsent("Rafael", name -> new ArrayList<>()).add("Star Wars");
        System.out.println(friendsToMove);

        //Replacement Patterns
        mutableMap.replaceAll(agePlusLength);
        System.out.println(mutableMap);
    }
}