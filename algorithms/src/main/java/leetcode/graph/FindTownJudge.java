package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/find-the-town-judge/
final class FindTownJudge {

    public static void main(String[] args) {
//        System.out.println(findJudge(2, new int[][] {{1,2}}));
//        System.out.println(findJudge(3, new int[][] {{1,3},{2,3}}));
//        System.out.println(findJudge(3, new int[][] {{1,3},{2,3}, {3, 1}}));
//        System.out.println(findJudge(3, new int[][] {{1,2},{2,3}}));
//        System.out.println(findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
        System.out.println(findJudge(1000, new int[][] {}));

    }

    public static int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> trustedBy = new HashMap<>();
        List<Integer> trustsNobody = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        for (int[] curr : trust) {
            int i = curr[0], v = curr[1];
            trustsNobody.remove(Integer.valueOf(i));
            trustedBy.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
        }

        int judge = -1;
        if (trustsNobody.size() == 1 && (trust.length == 0 ||
                trustedBy.get(trustsNobody.get(0)) != null && trustedBy.get(trustsNobody.get(0)).size() == n - 1)) {
            judge = trustsNobody.get(0);
        }
        return judge;
    }
}
