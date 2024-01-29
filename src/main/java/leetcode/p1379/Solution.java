package leetcode.p1379;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || cloned.val == target.val) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy(original, cloned.right, target);
    }
}
