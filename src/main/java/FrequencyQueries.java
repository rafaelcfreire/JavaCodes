import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FrequencyQueries {
    public static void main(String[] args) throws Exception {
        /*
        List<Integer> results = freqQuery(List.of(
            List.of(1, 5),
            List.of(1, 5),
            List.of(1, 6),
            List.of(1, 5),
            List.of(2, 5),
            List.of(3, 2),
            List.of(1, 10),
            List.of(1, 10),
            List.of(1, 6),
            List.of(2, 5),
            List.of(3, 2)
        ));
**/
        File f = new File("files/frequencyQueries2");
        BufferedReader b = new BufferedReader(new FileReader(f));
        List<int[]> lista = new ArrayList<>();

        for(int i = 1; i <= 100000; i++) {
            String temp1 = b.readLine();
            String[] temp = temp1.split(" ");
            int[] numbers = new int[temp.length];
            numbers[0] = Integer.parseInt(temp[0]);
            numbers[1] = Integer.parseInt(temp[1]);

            lista.add(numbers);
        }

        List<Integer> results = freqQuery(lista);
        results.forEach(System.out::println);
    }

    static List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Integer> ocurrences = new HashMap<>();
        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        queries.stream().forEach(innerList -> {
            if(innerList[0] == 1) {
                if(ocurrences.containsKey(innerList[1])) {

                    if(frequencies.get(ocurrences.get(innerList[1])).size() == 1){
                        frequencies.remove(ocurrences.get(innerList[1]));
                    } else {
                        frequencies.put(ocurrences.get(innerList[1]),
                                frequencies.get(ocurrences.get(innerList[1]))
                                        .stream()
                                        .filter(intValue -> !intValue.equals(innerList[1]))
                                        .collect(Collectors.toList()));
                    }

                    ocurrences.put(innerList[1], ocurrences.get(innerList[1]) + 1);
                } else {
                    ocurrences.put(innerList[1], 1);
                }
                if (frequencies.get(ocurrences.get(innerList[1])) == null
                        || frequencies.get(ocurrences.get(innerList[1])).isEmpty()) {

                    frequencies.put(ocurrences.get(innerList[1]), Arrays.asList(innerList[1]));
                } else {
                    frequencies.put(ocurrences.get(innerList[1]),
                            Stream.concat(frequencies.get(ocurrences.get(innerList[1])).stream(),
                                    Stream.of(innerList[1]))
                                    .collect(Collectors.toList())
                    );
                }
            } else if(innerList[0] == 2){

                if(ocurrences.containsKey(innerList[1])) {
                    if(frequencies.get(ocurrences.get(innerList[1])).size() == 1){
                        frequencies.remove(ocurrences.get(innerList[1]));
                    } else {
                        frequencies.put(ocurrences.get(innerList[1]),
                                frequencies.get(ocurrences.get(innerList[1]))
                                        .stream()
                                        .filter(intValue -> !intValue.equals(innerList[1]))
                                        .collect(Collectors.toList()));
                    }

                    if(ocurrences.get(innerList[1]) > 1) {
                        ocurrences.put(innerList[1], ocurrences.get(innerList[1]) - 1);
                    } else {
                        ocurrences.remove(innerList[1]);
                    }

                    if (frequencies.get(ocurrences.get(innerList[1])) == null
                            || frequencies.get(ocurrences.get(innerList[1])).isEmpty()) {

                        frequencies.put(ocurrences.get(innerList[1]), Arrays.asList(innerList[1]));
                    } else {
                        frequencies.put(ocurrences.get(innerList[1]),
                                Stream.concat(frequencies.get(ocurrences.get(innerList[1])).stream(),
                                        Stream.of(innerList[1]))
                                        .collect(Collectors.toList())
                        );
                    }
                }
            } else if(innerList[0] == 3){
                if(frequencies.get(innerList[1]) != null && !frequencies.get(innerList[1]).isEmpty()){
                    results.add(1);
                } else {
                    results.add(0);
                }
            }
        });

        return results;
    }
}
