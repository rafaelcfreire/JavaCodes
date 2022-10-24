package algoexpert.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MultiStringSearch {
//    static char endSymbol = '*';

    static class TrieNodeLocal {
        Map<Character, TrieNodeLocal> children = new HashMap<>();
    }

    public static void main(String[] args) {
//        multiStringSearch("abcdefghijklmnopqrstuvwxyz", new String[]{"abc", "mnopqr", "wyz", "no", "e", "tuuv"});
        multiStringSearch("this is a big string", new String[]{"this", "yo", "is", "a", "bigger", "string", "kappa"});
//        multiStringSearch("bbbabb", new String[]{"bbabb"});
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        TrieNodeLocal root = new TrieNodeLocal();
        List<Boolean> results = new ArrayList<>();

        buildTrie(root, bigString);

        for (String str : smallStrings)
            results.add(findSmallStrings(root, str));

        return results;
    }

    private static void buildTrie(TrieNodeLocal root, String str) {
        int n = str.length();

        for(int i = 0; i < n; i++) {
            TrieNodeLocal node = root;
            for (int j = i; j < n; j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter))
                    node.children.put(letter, new TrieNodeLocal());
                node = node.children.get(letter);
            }
        }
    }

    private static boolean findSmallStrings(TrieNodeLocal node, String str) {
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter))
                return false;
            node = node.children.get(letter);
        }
        return true;
    }
}
