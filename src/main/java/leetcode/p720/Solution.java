package leetcode.p720;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    private class Node {
        String value;
        Node[] children;
    }

    private String res = "";

    public String longestWord(String[] words) {
        Node root = new Node();
        root.value = "";
        for (String word : words) {
            insert(root, word);
        }

        dfs(root);
        return res;
    }

    private void insert(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children == null) {
                node.children = new Node[26];
            }
            Node child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new Node();
                node.children[word.charAt(i) - 'a'] = child;
            }
            node = child;
        }
        node.value = word;
    }

    private void dfs(Node node) {
        if (node == null || node.value == null) {
            return;
        }

        if (node.value.length() > res.length()) {
            res = node.value;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child);
            }
        }
    }
}
