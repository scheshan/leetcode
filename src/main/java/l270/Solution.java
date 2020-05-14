package l270;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    Integer res = null;

    public int closestValue(TreeNode root, double target) {
        travel(root, target);
        return res;
    }

    private void travel(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        if (res == null || Math.abs(node.val - target) < Math.abs(res - target)) {
            res = node.val;
        }
        if (node.val < target) {
            travel(node.right, target);
        } else {
            travel(node.left, target);
        }
    }
}
