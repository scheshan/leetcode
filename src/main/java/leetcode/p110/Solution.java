package leetcode.p110;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);

        return balanced;
    }

    private int getHeight(TreeNode node) {
        if (node == null || !balanced) {
            return 0;
        }

        int l = getHeight(node.left), r = getHeight(node.right);

        if (Math.abs(l - r) > 1) {
            balanced = false;
        }

        return Math.max(l, r) + 1;
    }
}
