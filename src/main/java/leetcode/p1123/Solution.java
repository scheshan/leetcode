package leetcode.p1123;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    private int level;
    private TreeNode res;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root, 1);
        return res;
    }

    private int dfs(TreeNode node, int level) {
        if (node == null) {
            return level;
        }

        int left = dfs(node.left, level + 1);
        int right = dfs(node.right, level + 1);

        if (left == right) {
            if (left >= this.level) {
                this.level = left;
                this.res = node;
            }
            return left;
        } else {
            return Math.max(left, right);
        }
    }
}
