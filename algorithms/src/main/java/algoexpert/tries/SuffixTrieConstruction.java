package algoexpert.tries;

import java.util.HashMap;
import java.util.Map;

public final class SuffixTrieConstruction {

    public static void main(String[] args) {
        SuffixTrie sf = new SuffixTrie("babc");
        sf.contains("abc");
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++)
                insertElementTrie(str, i);
        }

        private void insertElementTrie(String str, int idx) {
            TrieNode node = root;

            for (int i = idx; i < str.length(); i++) {
                char curr = str.charAt(i);
                if (!node.children.containsKey(curr)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(curr, newNode);
                }
                node = node.children.get(curr);
            }
            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode node = root;

            for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                if (!node.children.containsKey(curr))
                    return false;
                node = node.children.get(curr);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
