package hackerrank.graph;

import java.util.*;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem?isFullScreen=false
final class JourneyToTheMoon {
    public static void main(String[] args) {
        System.out.println(journeyToMoon(5, List.of(List.of(0, 1), List.of(2, 3), List.of(0, 4))));
    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        Map<Integer, Integer> mapOfEntries = new HashMap<>();
        int currCountry = 1;
        for (List<Integer> pair : astronaut) {
            int i = pair.get(0), v = pair.get(1);
            if (mapOfEntries.get(i) == null && mapOfEntries.get(v) == null) {
                mapOfEntries.put(i, currCountry);
                mapOfEntries.put(v, currCountry++);
            }
            if (mapOfEntries.get(v) == null) {
                mapOfEntries.put(v, mapOfEntries.get(i));
            }
            if (mapOfEntries.get(i) == null) {
                mapOfEntries.put(i, mapOfEntries.get(v));
            }
        }

        List<List<Integer>> astronautsPerCountry = new ArrayList<>();
        for (int i = 0; i < currCountry; i++)
            astronautsPerCountry.add(new ArrayList<>());

        for (var curr : mapOfEntries.entrySet()) {
            astronautsPerCountry.get(curr.getValue()).add(curr.getKey());
        }

        int total = 0;
        for (int currAstrounaut : astronautsPerCountry.get(1)) {
            List<Integer> pairs = new ArrayList<>();
            pairs.add(currAstrounaut);
            pairs.addAll(astronautsPerCountry.stream().skip(2).flatMap(List::stream).collect(Collectors.toList()));

            total += getPermutations(pairs);
        }
        return total;
    }

    public static int getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();

        permutationHelper(array, new ArrayList<>(), permutations);

        return permutations.size();
    }

    private static void permutationHelper(List<Integer> array, List<Integer> currentPermutation,
                                          List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                permutationHelper(newArray, newPermutation, permutations);
            }
        }
    }
}