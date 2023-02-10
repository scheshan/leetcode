package leetcode.p2415;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root, root, 0);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null) {
            return;
        }

        if ((level & 1) == 1) {
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }

        dfs(left.left, right.right, level + 1);
        if (left != right) {
            dfs(left.right, right.left, level + 1);
        }
    }
}
