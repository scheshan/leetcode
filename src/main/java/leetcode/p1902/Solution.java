package leetcode.p1902;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    private class Node {

        private int level;

        private int val;

        private Node left;

        private Node right;

        public Node(int level, int val) {
            this.level = level;
            this.val = val;
        }
    }

    private Node root;

    private Node min;

    private Node max;

    public int maxDepthBST(int[] order) {
        int res = 1;
        root = new Node(1, order[0]);
        min = root;
        max = root;

        for (int i = 1; i < order.length; i++) {
            res = Math.max(res, insert(root, order[i]));
        }
        return res;
    }

    private int insert(Node node, int value) {
        if (value < min.val) {
            min.left = new Node(min.level + 1, value);
            min = min.left;
            return min.level;
        } else if (value > max.val) {
            max.right = new Node(max.level + 1, value);
            max = max.right;
            return max.level;
        } else {
            while (node != null) {
                if (node.val > value) {
                    if (node.left == null) {
                        node.left = new Node(node.level + 1, value);
                        node = node.left;
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(node.level + 1, value);
                        node = node.right;
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
            return node.level;
        }
    }
}
