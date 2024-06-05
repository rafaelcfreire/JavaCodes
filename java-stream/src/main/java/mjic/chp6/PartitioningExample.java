package mjic.chp6;

import mjic.chp4.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static mjic.chp4.DishList.menu;

final class PartitioningExample {
    public static void main(String[] args) {
        //Partitioning by vegetarian
        Map<Boolean, List<Dish>> partitionMenuWithGrouping = menu.stream()
                .collect(groupingBy(Dish::isVegetarian, toList()));
        System.out.println(partitionMenuWithGrouping);

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("Most caloric partitioned by vegetarian: "+mostCaloricPartitionedByVegetarian);

        List<Dish> list = menu.stream().map(Function.identity()).collect(toList());
        System.out.println(list);
    }
}