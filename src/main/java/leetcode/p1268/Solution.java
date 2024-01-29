package leetcode.p1268;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    private class Node {
        String word;
        TreeMap<Character, Node> children;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String word : products) {
            insert(root, word);
        }

        List<List<String>> res = new ArrayList<>(searchWord.length());
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(new ArrayList<>(3));
        }
        Node node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = res.get(i);

            if (node.children == null || !node.children.containsKey(searchWord.charAt(i))) {
                break;
            }
            node = node.children.get(searchWord.charAt(i));
            travel(node, list);
        }

        return res;
    }

    private void insert(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children == null) {
                node.children = new TreeMap<>();
            }
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new Node());
            }
            node = node.children.get(word.charAt(i));
        }

        node.word = word;
    }

    private void travel(Node node, List<String> list) {
        if (node == null || list.size() == 3) {
            return;
        }

        if (node.word != null) {
            list.add(node.word);
        }

        if (node.children != null) {
            for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                travel(entry.getValue(), list);
            }
        }
    }
}
