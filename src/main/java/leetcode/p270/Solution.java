package leetcode.p270;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/25
 */
public class Solution {

    private int res;

    private double min = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        while (node != null) {
            if (Math.abs(node.val - target) < min) {
                min = Math.abs(node.val - target);
                res = node.val;
            }
            if (node.val > target) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }
}
