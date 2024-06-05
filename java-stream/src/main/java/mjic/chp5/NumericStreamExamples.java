package mjic.chp5;

import mjic.chp4.Dish;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static mjic.chp4.DishList.menu;

final class NumericStreamExamples {
    public static void main(String[] args) {
        OptionalInt maxCaloriesInteger = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        OptionalDouble maxCaloriesDouble = menu.stream()
                .mapToDouble(Dish::getCalories)
                .max();

        OptionalLong maxCaloriesLong = menu.stream()
                .mapToLong(Dish::getCalories)
                .max();

        // From IntStream to Stream using boxed
        Stream<Integer> stream = IntStream.range(0, 50).boxed();
    }
}