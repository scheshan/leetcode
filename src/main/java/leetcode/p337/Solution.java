package leetcode.p337;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int rob(TreeNode root) {
        int[] res = rob0(root);
        return Math.max(res[0], res[1]);
    }

    private int[] rob0(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = rob0(root.left);
        int[] right = rob0(root.right);

        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
