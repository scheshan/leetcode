package leetcode.p124;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    private Integer res = null;

    public int maxPathSum(TreeNode root) {
        travel(root);

        return res;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, travel(node.left));
        int right = Math.max(0, travel(node.right));
        int r = node.val + left + right;

        if (res == null) {
            res = r;
        } else {
            res = Math.max(res, r);
        }
        return Math.max(left, right) + node.val;
    }
}
