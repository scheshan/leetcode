package l236;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null || right == null) {
            return left != null ? left : right;
        } else {
            return root;
        }
    }
}
