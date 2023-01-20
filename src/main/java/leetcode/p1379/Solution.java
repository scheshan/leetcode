package leetcode.p1379;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }

        if (find(cloned, target)) {
            return cloned;
        }
        TreeNode res = getTargetCopy(original, cloned.left, target);
        if (res != null) {
            return res;
        }
        return getTargetCopy(original, cloned.right, target);
    }

    private boolean find(TreeNode node, TreeNode target) {
        if (node == null) {
            return target == null;
        }

        if (target == null || node.val != target.val) {
            return false;
        }

        return find(node.left, target.left) && find(node.right, target.right);
    }
}
