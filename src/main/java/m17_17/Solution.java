package m17_17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int[][] multiSearch(String big, String[] smalls) {
        Node root = new Node(' ');
        for (int i = 0; i < smalls.length; i++) {
            insert(root, smalls[i], i);
        }

        List[] arr = new List[smalls.length];
        for (int i = 0; i < big.length(); i++) {
            List<Integer> list = new LinkedList<>();
            find(root, big, i, list);

            for (int ind : list) {
                if (arr[ind] == null) {
                    arr[ind] = new LinkedList();
                }
                arr[ind].add(i);
            }
        }

        int[][] result = new int[smalls.length][];
        for (int i = 0; i < result.length; i++) {
            List<Integer> list = arr[i];
            if (list == null) {
                result[i] = new int[0];
            } else {
                result[i] = new int[list.size()];
                int j = 0;
                for (int n : list) {
                    result[i][j++] = n;
                }
            }
        }

        return result;
    }

    private void insert(Node node, String word, int index) {
        for (int i = 0; i < word.length(); i++) {
            node = node.children.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new Node(k);
                }
                return v;
            });
            if (i == word.length() - 1) {
                node.index = index;
            }
        }
    }

    private void find(Node node, String big, int i, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.index >= 0) {
            res.add(node.index);
        }

        if (i >= big.length()) {
            return;
        }

        find(node.children.get(big.charAt(i)), big, i + 1, res);
    }

    private class Node {
        private int index;

        private char ch;

        private Map<Character, Node> children;

        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
            index = -1;
        }
    }

    public static void main(String[] args) {
        new Solution().multiSearch("mis", new String[]{"is"});
    }
}
