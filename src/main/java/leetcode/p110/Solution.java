package leetcode.p110;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (!res) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.abs(left - right) > 1) {
            res = false;
            return 0;
        }

        return Math.max(left, right) + 1;
    }
}
