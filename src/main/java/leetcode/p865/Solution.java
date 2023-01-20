package leetcode.p865;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            int left = maxDepth(node.left);
            int right = maxDepth(node.right);

            if (left == right) {
                return node;
            } else if (left < right) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
