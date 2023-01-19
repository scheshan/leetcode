package leetcode.p235;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode low = p;
        TreeNode high = q;
        if (p.val > q.val) {
            low = q;
            high = p;
        }

        TreeNode res = root;
        while (res != null) {
            if (res.val > high.val) {
                res = res.left;
            } else if (res.val < low.val) {
                res = res.right;
            } else {
                return res;
            }
        }
        return null;
    }
}
