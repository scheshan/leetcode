package l270;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }
}
