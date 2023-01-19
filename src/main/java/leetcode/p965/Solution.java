package leetcode.p965;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && (root.left.val != root.val || !isUnivalTree(root.left))) {
            return false;
        }
        if (root.right != null && (root.right.val != root.val || !isUnivalTree(root.right))) {
            return false;
        }
        return true;
    }
}
