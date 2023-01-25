package leetcode.p1644;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/25
 */
public class Solution {

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        if (left && right) {
            res = node;
            return true;
        } else if ((left || right) && (node.val == p.val || node.val == q.val)) {
            res = node;
            return true;
        }

        return left || right || node.val == p.val || node.val == q.val;
    }
}
