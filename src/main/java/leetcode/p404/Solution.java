package leetcode.p404;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return left ? node.val : 0;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
