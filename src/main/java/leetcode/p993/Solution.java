package leetcode.p993;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    private int lca;

    private int l1;

    private int l2;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 1);
        return l1 == l2 && l1 - lca > 1;
    }

    private boolean dfs(TreeNode node, int x, int y, int level) {
        if (node == null) {
            return false;
        }

        boolean left = dfs(node.left, x, y, level + 1);
        boolean right = dfs(node.right, x, y, level + 1);
        if (left && right) {
            lca = level;
            return true;
        } else {
            if (node.val == x) {
                l1 = level;
                lca = level;
            } else if (node.val == y) {
                l2 = level;
                lca = level;
            }
            return left || right || node.val == x || node.val == y;
        }
    }
}
