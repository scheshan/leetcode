package l235;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
