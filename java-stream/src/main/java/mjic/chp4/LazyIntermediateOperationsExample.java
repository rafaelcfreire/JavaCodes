package mjic.chp4;

import java.util.List;
import java.util.stream.Collectors;

import static mjic.chp4.DishList.menu;

final class LazyIntermediateOperationsExample {
    public static void main(String[] args) {
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: "+dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: "+dish.getName());
                    return dish.getName();
                })
                //notice how only 3 dishes are printed on the upper operations.
                //It is due to the nature of compute on demand ("lazily")
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}