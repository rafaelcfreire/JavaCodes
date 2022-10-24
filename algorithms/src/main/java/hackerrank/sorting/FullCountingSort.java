package hackerrank.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FullCountingSort {
    public static void main(String[] args) {
        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("0", "ab"));
        arr.add(Arrays.asList("6", "cd"));
        arr.add(Arrays.asList("0", "ef"));
        arr.add(Arrays.asList("6", "gh"));
        arr.add(Arrays.asList("4", "ij"));
        arr.add(Arrays.asList("0", "ab"));
        arr.add(Arrays.asList("6", "cd"));
        arr.add(Arrays.asList("0", "ef"));
        arr.add(Arrays.asList("6", "gh"));
        arr.add(Arrays.asList("0", "ij"));
        arr.add(Arrays.asList("4", "that"));
        arr.add(Arrays.asList("3", "be"));
        arr.add(Arrays.asList("0", "to"));
        arr.add(Arrays.asList("1", "be"));
        arr.add(Arrays.asList("5", "question"));
        arr.add(Arrays.asList("1", "or"));
        arr.add(Arrays.asList("2", "not"));
        arr.add(Arrays.asList("4", "is"));
        arr.add(Arrays.asList("2", "to"));
        arr.add(Arrays.asList("4", "the"));

        countSort(arr);
    }

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        List<Pair> pairs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n / 2; i++)
            arr.set(i, Arrays.asList(arr.get(i).get(0), "-"));

        for (int i = 0; i < n; i++) {
            List<String> curr = arr.get(i);
            pairs.add(new Pair(curr.get(1), Integer.parseInt(curr.get(0))));
        }

        Pair max = Collections.max(pairs);
        int digit = 0;

        while ((max.value / Math.pow(10, digit)) > 1) {
            sort(pairs, digit);
            digit++;
        }
        for (int i = 0; i < n; i++)
            sb.append(i == 0 ? pairs.get(i).name : " " + pairs.get(i).name);

        System.out.print(sb);
//        for (int i = 0; i < n; i++)
//            System.out.print(i == 0 ? pairs.get(i).name : " " + pairs.get(i).name);
    }

    private static void sort(List<Pair> pairs, int digit) {
        int n = pairs.size();
        int R = 10;
        Pair[] aux = new Pair[n];
        int[] count = new int[R + 1];

        for (int i = 0; i < n; i++) {
            int value = (int)(pairs.get(i).value / Math.pow(10, digit)) % 10;
            count[value + 1]++;
        }

        for (int i = 0; i < R; i++)
            count[i + 1] += count[i];

        for (int i = 0; i < n; i++) {
            int value = (int)(pairs.get(i).value / Math.pow(10, digit)) % 10;
            aux[count[value]++] = pairs.get(i);
        }

        for (int i = 0; i < n; i++)
            pairs.set(i, aux[i]);
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        String name;

        public Pair(String name, int value) {
            this.value = value;
            this.name = name;
        }

        @Override
        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }
}
