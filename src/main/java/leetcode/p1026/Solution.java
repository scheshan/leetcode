package leetcode.p1026;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }

        int res = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        res = Math.max(res, dfs(node.left, min, max));
        res = Math.max(res, dfs(node.right, min, max));
        return res;
    }
}
