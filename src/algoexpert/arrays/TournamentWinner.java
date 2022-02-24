package algoexpert.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {
    public static void main(String[] args) {
        tournamentWinner(List.of(List.of("HTML", "C#"), List.of("C#", "Python"), List.of("Python", "HTML")),
                List.of(0, 0, 1));
    }

    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        String tempWinner = "";
        Map<String, Integer> table = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 0) {
                table.put(competitions.get(i).get(1), 
                        table.containsKey(competitions.get(i).get(1)) ? table.get(competitions.get(i).get(1)) + 3 : 3);
            } else {
                table.put(competitions.get(i).get(0),
                        table.containsKey(competitions.get(i).get(0)) ? table.get(competitions.get(i).get(0)) + 3 : 3);
            }
            if (tempWinner.isEmpty() ||
                    table.get(results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0)) > table.get(tempWinner))
                tempWinner = results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0);
        }
        return tempWinner;
    }
}
