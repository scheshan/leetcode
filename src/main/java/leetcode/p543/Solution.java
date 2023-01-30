package leetcode.p543;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res - 1;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
