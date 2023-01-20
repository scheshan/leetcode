package leetcode.p1973;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    int res;

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left + right == node.val && (node.left != null || node.right != null)) {
            res++;
        } else if (node.val == 0 && node.left == null && node.right == null) {
            res++;
        }
        return left + right + node.val;
    }
}
