package lcp.p67;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            TreeNode left = new TreeNode(-1);
            left.left = expandBinaryTree(root.left);
            root.left = left;
        }
        if (root.right != null) {
            TreeNode right = new TreeNode(-1);
            right.right = expandBinaryTree(root.right);
            root.right = right;
        }
        return root;
    }
}
