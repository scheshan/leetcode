package leetcode.p1372;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    private int res;

    public int longestZigZag(TreeNode root) {
        travel(root, 0, 0);
        return res;
    }

    private void travel(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }

        res = Math.max(res, left);
        res = Math.max(res, right);

        travel(node.left, right + 1, 0);
        travel(node.right, 0, left + 1);
    }
}
