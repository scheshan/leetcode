package leetcode.p530;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    int res = Integer.MAX_VALUE;

    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (pre != null) {
            res = Math.min(res, Math.abs(node.val - pre.val));
        }
        pre = node;

        dfs(node.right);
    }
}
