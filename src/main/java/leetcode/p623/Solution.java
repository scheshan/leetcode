package leetcode.p623;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, val, depth, true);
    }

    private TreeNode dfs(TreeNode node, int val, int depth, boolean left) {
        if (depth == 1) {
            TreeNode res = new TreeNode(val);
            if (left) {
                res.left = node;
            } else {
                res.right = node;
            }
            return res;
        }

        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, val, depth - 1, true);
        node.right = dfs(node.right, val, depth - 1, false);
        return node;
    }
}
