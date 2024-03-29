package leetcode.p236;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}
