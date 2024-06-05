package fpij.chp2;

import java.util.function.Function;
import java.util.function.Predicate;

import static fpij.chp2.CollectionsSupplier.*;

final class LexicalScope {
    public static void main(String[] args) {
        Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendsStartN = FRIENDS.stream().filter(startsWithLetter.apply("N")).count();

        final long countEditorsStartN = EDITORS.stream().filter(startsWithLetter.apply("N")).count();

        final long countComradesStartN = COMRADES.stream().filter(startsWithLetter.apply("N")).count();

        System.out.println(countFriendsStartN);
        System.out.println(countEditorsStartN);
        System.out.println(countComradesStartN);
    }

    static Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

    static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
