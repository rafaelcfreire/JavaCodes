package mjic.chp6;

import mjic.chp4.Dish;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static mjic.chp4.DishList.menu;

final class CollectorsExamples {
    public static void main(String[] args) {
        //Example of Collectors.summarizingInt
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("IntSummaryStatistics: "+menuStatistics);

        //Example of Collectors.reducing with an identity, a transformation function and a BinaryOperator to sum elements
        int sum = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("Reducing to a sum: "+sum);

        //Groupings
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("Grouping by Dish types: "+dishesByType);

        //Grouping with filtering
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
        System.out.println("Grouping with filter which excludes the categories under 500 calories: "+caloricDishesByType);

        Map<Dish.Type, List<Dish>> caloricDishesByTypeWithFilterOnCollect = menu.stream()
                .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println("Grouping with filter which includes the categories under 500 calories: "+caloricDishesByTypeWithFilterOnCollect);

        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
                        .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println("Grouping with mapping method: "+dishNamesByType);

        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println("Types counting: "+typesCount);

        //Most caloric by type
        Map<Dish.Type, Optional<Dish>> mostCaloricByOptionalType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println("Most caloric by Optional types: "+mostCaloricByOptionalType);

        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("Most caloric by types: "+mostCaloricByType);
    }
}