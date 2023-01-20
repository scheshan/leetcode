package leetcode.p1448;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    int res;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (max <= node.val) {
            res++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
