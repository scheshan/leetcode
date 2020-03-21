package l720;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    private String result = "";

    private Node root = new Node(' ');

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(root, word);
        }

        return find(root);
    }

    private void insert(Node node, String word) {
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

    private String find(Node root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);

        return result;
    }

    private void dfs(Node node, StringBuilder sb) {
        if (!node.end && node != root) {
            return;
        }

        if (node != root) {
            sb.append(node.ch);
            if (sb.length() > result.length()) {
                result = sb.toString();
            } else if (sb.length() == result.length()) {
                String str = sb.toString();
                if (str.compareTo(result) < 0) {
                    result = str;
                }
            }
        }

        for (Node child : node.children.values()) {
            dfs(child, sb);
        }

        if (node != root) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private class Node {

        private Map<Character, Node> children;

        private char ch;

        private boolean end;

        public Node(char ch) {
            this.ch = ch;

            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        new Solution().longestWord(new String[]{"m", "ma", "mat", "math", "s", "sc", "sci", "scie", "scien", "scienc", "science", "a", "ar", "art"});
    }
}
