package leetcode.p124;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        travel(root);

        return max;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = travel(node.left);
        int right = travel(node.right);

        max = Math.max(max, left + node.val);
        max = Math.max(max, right + node.val);
        max = Math.max(max, left + right + node.val);
        max = Math.max(max, node.val);

        int res = Math.max(left + node.val, node.val);
        res = Math.max(res, right + node.val);
        return res;
    }
}
