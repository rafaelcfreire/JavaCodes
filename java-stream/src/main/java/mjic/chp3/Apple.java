package mjic.chp3;

import java.util.Comparator;
import java.util.List;

final class Apple {
    final String type;
    final Integer weight;

    private Apple(final String type, final int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple: "+type+" weight: "+weight;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(new Apple("a", 15), new Apple("b", 3), new Apple("c", 87));

        apples.stream().sorted(Comparator.comparing(a -> a.weight)).forEach(System.out::println);
    }
}