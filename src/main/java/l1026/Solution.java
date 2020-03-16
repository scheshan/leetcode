package l1026;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    private int result;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        travel(root, root.val, root.val);

        return result;
    }

    private void travel(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }

        result = Math.max(result, Math.abs(node.val - min));
        result = Math.max(result, Math.abs(node.val - max));

        if (node.val < min) {
            min = node.val;
        }
        if (node.val > max) {
            max = node.val;
        }

        travel(node.left, min, max);
        travel(node.right, min, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);

        new Solution().maxAncestorDiff(root);
    }
}
