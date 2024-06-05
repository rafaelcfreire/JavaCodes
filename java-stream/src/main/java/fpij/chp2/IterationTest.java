package fpij.chp2;

import java.util.List;

import static fpij.chp2.CollectionsSupplier.FRIENDS;

final class IterationTest {
    public static void main(String[] args) {
        final List<String> friends = FRIENDS;

        friends.forEach(name -> {
            name = name.concat("Suffix");
            System.out.println(name);
        });

        friends.forEach(System.out::println);
    }
}
