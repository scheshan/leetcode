package leetcode.p2331;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left | right;
        } else {
            return left && right;
        }
    }
}
