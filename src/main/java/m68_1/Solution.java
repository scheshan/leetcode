package m68_1;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/4
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (root.val == p.val || root.val == q.val || (root.val > min && root.val < max)) {
            return root;
        }

        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
