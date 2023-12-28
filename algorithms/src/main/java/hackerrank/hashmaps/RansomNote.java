package hackerrank.hashmaps;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
final class RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Long> magazineEntries = magazine.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String result = "Yes";
        for (String currNote : note) {
            if (magazineEntries.containsKey(currNote)) {
                long remaining = magazineEntries.computeIfPresent(currNote, (a, b) ->  b - 1);
                if (remaining == 0)
                    magazineEntries.remove(currNote);
            } else {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
//        List<String> magazine = List.of("give", "me", "one", "grand", "today", "night");
//        List<String> notes = List.of("give", "one", "grand", "today");
        List<String> magazine = List.of("two", "times", "three", "is", "not", "four");
        List<String> notes = List.of("two", "times", "two", "is", "four");

        checkMagazine(magazine, notes);
    }
}
