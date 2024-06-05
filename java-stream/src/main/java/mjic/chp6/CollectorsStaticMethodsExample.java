package mjic.chp6;

import mjic.chp4.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static mjic.chp4.DishList.menu;

final class CollectorsStaticMethodsExample {
    public static void main(String[] args) {
        //toList
        List<Dish> dishes = menu.stream().collect(toList());

        //toSet
        Set<Dish> dishesSet = menu.stream().collect(toSet());

        //toCollection
        Collection<Dish> dishesCollection = menu.stream().collect(toCollection(ArrayList::new));

        //couting
        long dishesCounting = menu.stream().collect(counting());

        //summingInt
        int dishesSumming = menu.stream().collect(summingInt(Dish::getCalories));

        //averageInt
        double dishesAverage = menu.stream().collect(averagingInt(Dish::getCalories));

        //summarizingInt
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        //joining
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

        //maxBy with Optional
        Optional<Dish> optionalMaxBy = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));

        //maxBy
        Dish maxBy = menu.stream().collect(collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get));

        //minBy with Optional
        Optional<Dish> optionalMinBy = menu.stream().collect(minBy(comparingInt(Dish::getCalories)));

        //minBy
        Dish minBy = menu.stream().collect(collectingAndThen(minBy(comparingInt(Dish::getCalories)), Optional::get));

        //reducing
        menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        Dish dish = new Dish("temp", true, 500, Dish.Type.OTHER);
        Dish local = menu.stream().collect(reducing(dish, dishBinaryOperator));

        //collectingAndThen
        int howManyDishes = menu.stream().collect(collectingAndThen(toList(), List::size));
        System.out.println("How many dishes: "+howManyDishes);

        //groupingBy
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType, toList()));
        System.out.println(dishesByType);

        //partitioningBy
        Map<Boolean, List<Dish>> vegetarianDishes = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(vegetarianDishes);
    }

    static BinaryOperator<Dish> dishBinaryOperator = (d1, d2) -> new Dish("temp2", true, 500, Dish.Type.OTHER);
}