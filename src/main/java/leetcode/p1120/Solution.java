package leetcode.p1120;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    double res;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private long[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        long[] left = dfs(root.left);
        long[] right = dfs(root.right);

        long sum = root.val;
        long total = 1;
        if (left != null) {
            sum += left[0];
            total += left[1];
        }
        if (right != null) {
            sum += right[0];
            total += right[1];
        }

        res = Math.max(res, sum * 1.0 / total);
        return new long[]{sum, total};
    }
}
