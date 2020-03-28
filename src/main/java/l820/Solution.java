package l820;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        for (String word : words) {
            insert(root, word);
        }

        return count(root, 0);
    }

    private void insert(Node root, String word) {
        Node node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            node = node.children.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new Node();
                }
                return v;
            });
        }
    }

    private int count(Node node, int n) {
        n++;
        if (node.children.size() == 0) {
            return n;
        }

        int res = 0;
        for (Node child : node.children.values()) {
            res += count(child, n);
        }
        return res;
    }

    private class Node {

        private Map<Character, Node> children;

        public Node() {
            this.children = new HashMap<>();
        }
    }
}
