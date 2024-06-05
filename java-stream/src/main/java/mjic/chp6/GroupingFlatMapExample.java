package mjic.chp6;

import mjic.chp4.Dish;
import mjic.chp4.DishList.CaloricLevel;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static mjic.chp4.DishList.menu;

final class GroupingFlatMapExample {
    static final Map<String, List<String>> dishTags = Map.of("pork", asList("greasy", "salty"),
            "beef", asList("salty", "roasted"), "chicken", asList("fried", "crisp"),
            "french fries", asList("greasy", "fried"), "rice", asList("light", "natural"),
            "season fruit", asList("fresh", "natural"), "pizza", asList("tasty", "salty"),
            "prawns", asList("tasty", "roasted"), "salmon", asList("delicious", "fresh")
            );

    public static void main(String[] args) {
        Map<Dish.Type, Set<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
        System.out.println(dishNamesByType);

        //Multilevel Grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricalLevel = menu.stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                })));
        System.out.println(dishesByTypeCaloricalLevel);
    }
}