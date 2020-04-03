package l1268;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    private Node root = new Node(' ');

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new LinkedList<>();

            Node node = find(root, searchWord, i);
            travel(node, list);

            res.add(list);
        }

        return res;
    }

    private void insert(Node root, String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            node = node.children.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new Node(k);
                }
                return v;
            });
            if (i == word.length() - 1) {
                node.word = word;
            }
        }
    }

    private Node find(Node root, String word, int i) {
        Node node = root;
        for (int j = 0; j <= i && node != null; j++) {
            node = node.children.get(word.charAt(j));
        }
        return node;
    }

    private void travel(Node node, List<String> res) {
        if (node == null) {
            return;
        }

        if (res.size() == 3) {
            return;
        }

        if (node.word != null) {
            res.add(node.word);
        }

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            travel(entry.getValue(), res);
        }
    }

    private class Node {

        private char ch;

        private String word;

        private Map<Character, Node> children;

        public Node(char ch) {
            this.ch = ch;
            children = new TreeMap<>();
        }
    }
}
