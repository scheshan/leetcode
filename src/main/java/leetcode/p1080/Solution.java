package leetcode.p1080;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    private TreeNode dfs(TreeNode node, int cur, int limit) {
        if (node == null) {
            return null;
        }

        boolean hasChildren = node.left != null || node.right != null;
        cur += node.val;
        if (!hasChildren) {
            if (cur < limit) {
                return null;
            }
            return node;
        } else {
            node.left = dfs(node.left, cur, limit);
            node.right = dfs(node.right, cur, limit);

            if (node.left == null && node.right == null) {
                return null;
            }
            return node;
        }
    }
}
