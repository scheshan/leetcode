package leetcode.p114;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;

        if (pre != null) {
            pre.right = root;
        }
        pre = root;

        flatten(left);
        flatten(right);
    }
}
