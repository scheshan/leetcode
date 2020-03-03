package l965;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val != val) {
            return false;
        }

        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
