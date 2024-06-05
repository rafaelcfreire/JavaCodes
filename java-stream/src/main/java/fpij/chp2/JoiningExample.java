package fpij.chp2;

import java.util.List;
import java.util.stream.Collectors;

import static fpij.chp2.CollectionsSupplier.FRIENDS;

final class JoiningExample {
    public static void main(String[] args) {
        System.out.println(FRIENDS.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining()));


    }
}
