package leetcode.p1612;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        int[] count = new int[26];
        sum(root1, count, 1);
        sum(root2, count, -1);

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private void sum(Node node, int[] count, int delta) {
        if (node == null) {
            return;
        }

        if (node.val == '+') {
            sum(node.left, count, delta);
            sum(node.right, count, delta);
            return;
        }
        count[node.val - 'a'] += delta;
    }
}
