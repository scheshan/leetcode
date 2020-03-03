package l226;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;

        return root;
    }
}
