package leetcode.p572;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        } else {
            return n1.val == n2.val && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
        }
    }
}
