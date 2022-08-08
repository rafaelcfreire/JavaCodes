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
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Contacts {


    public static void main(String[] args) throws IOException {
        File f = new File("files/contacts");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long start = System.currentTimeMillis();
        Contacts.contacts(queries);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time Elapsed: "+timeElapsed);
        bufferedReader.close();
    }

//    public static void main(String[] args) {
//        List<List<String>> queries = new ArrayList<>();
//        // CASE 1
////        queries.add(new ArrayList<>(Arrays.asList("add", "hack")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "hackerrank")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "hac")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "hak")));
//        // CASE 2
////        queries.add(new ArrayList<>(Arrays.asList("add", "ed")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "eddie")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "edward")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "ed")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "edwina")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "edw")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "a")));
//        // CASE 3
////        queries.add(new ArrayList<>(Arrays.asList("add", "s")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "ss")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "sss")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "ssss")));
////        queries.add(new ArrayList<>(Arrays.asList("add", "sssss")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "s")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "ss")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "sss")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "ssss")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "sssss")));
////        queries.add(new ArrayList<>(Arrays.asList("find", "ssssss")));
//        contacts(queries);
//    }

    static class TrieNode {
        public int size = 0;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public static void contacts(List<List<String>> queries) {
        TrieNode root = new TrieNode();

        for (List<String> curr : queries) {
            String operation = curr.get(0), name = curr.get(1);

            if (operation.equals("add"))
                addStringToTrie(root, name);
            else if (operation.equals("find"))
                System.out.println(findStringInTrie(root, name));
        }
    }

    private static void addStringToTrie(TrieNode root, String str) {
        TrieNode node = root;
        char endSymbol = '*';

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            node.children.putIfAbsent(curr, new TrieNode());
            node = node.children.get(curr);
            node.size++;
        }
        node.children.put(endSymbol, null);
    }

    private static int findStringInTrie(TrieNode root, String str) {
        TrieNode curr = root;

        for (char ch : str.toCharArray()) {
            curr = curr.children.get(ch);
            if (curr == null)
                return 0;
        }
        return curr.size;
    }
}
