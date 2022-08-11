package hackerrank.tries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class NoPrefixSet {

    static char endpoint = '*';

//    public static void main(String[] args) {
////        noPrefix(List.of("aab", "defgab", "abcde", "aabcde", "bbbbbbbbbb", "jabjjjad"));
////        noPrefix(List.of("aab", "aac", "aacghgh", "aabghgh"));
////        noPrefix(List.of("ab", "bc", "cd"));
//        noPrefix(List.of("aab", "defgab", "abcde", "abc", "cedaaa", "bbbbbbbbbb", "jabjjjad"));
//    }

    public static void main(String[] args) throws IOException {
        File f = new File("files/NoPrefix2");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        noPrefix(words);

        bufferedReader.close();
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();
        List<String> duplicates = new ArrayList<>();

        for (String currWord : words) {
            TrieNode node = root;
            for (int i = 0; i < currWord.length(); i++) {
                char letter = currWord.charAt(i);
                if (node.children.containsKey(endpoint) ||
                        node.children.containsKey(letter) && i == currWord.length() - 1) {
                    duplicates.add(currWord);
                    break;
                }
                if (!node.children.containsKey(letter))
                    node.children.put(letter, new TrieNode());
                node = node.children.get(letter);
            }
            if (!duplicates.isEmpty())
                break;
            node.children.put(endpoint, new TrieNode());
        }
        if (duplicates.isEmpty())
            System.out.println("GOOD SET");
        else
            System.out.println(String.format("BAD SET \n%s", duplicates.get(0)));
    }
}
