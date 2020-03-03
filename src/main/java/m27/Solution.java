package m27;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;

        return root;
    }
}
