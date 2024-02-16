package leetcode.p617;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode res = new TreeNode();
        if (root1 != null) {
            res.val += root1.val;
        }
        if (root2 != null) {
            res.val += root2.val;
        }

        res.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        res.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        return res;
    }
}
