package leetcode.p530;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    private TreeNode pre;

    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        travel(root);

        return res;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }

        travel(node.left);
        if (pre != null) {
            res = Math.min(res, node.val - pre.val);
        }
        pre = node;
        travel(node.right);
    }
}
