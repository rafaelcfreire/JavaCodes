import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static void main(String[] args) {
        List<List<Integer>> queries = List.of(List.of(1, 0, 5), List.of(1, 1, 7), List.of(1, 0, 3),
                List.of(2, 1, 0), List.of(2, 1, 1));

        dynamicArray(2, queries);
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(n);
        for(int i=0; i < n; i++) {
            arr.add(new ArrayList());
        }
        List<Integer> returnValue = new ArrayList<>();

        for(List query : queries) {
            int index = (((int)query.get(1) ^ lastAnswer) % n);

            if((int)query.get(0) == 1) {
                arr.get(index).add((int)query.get(2));
            } else if((int)query.get(0) == 2) {
                lastAnswer = arr.get(index).get(((int)query.get(2)) % arr.get(index).size());
                returnValue.add(lastAnswer);
            }
        }

        return returnValue;
    }

}
