package l211;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.children.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new Node(k);
                }
                return v;
            });
            if (i == word.length() - 1) {
                node.end = true;
            }
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return find(root, word, 0);
    }

    private boolean find(Node node, String word, int i) {
        if (node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.end;
        }

        char ch = word.charAt(i);
        if (ch == '.') {
            for (Node child : node.children.values()) {
                if (find(child, word, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return find(node.children.get(ch), word, i + 1);
        }
    }

    private class Node {

        private char ch;

        private Map<Character, Node> children;

        private boolean end;

        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }
}
