package leetcode.p510;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node res = node.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        } else {
            Node parent = node.parent;
            while (parent != null && parent.val < node.val) {
                parent = parent.parent;
            }
            return parent;
        }
    }
}
