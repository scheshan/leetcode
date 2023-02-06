package leetcode.p333;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int largestBSTSubtree(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if (left[1] == 1 && right[1] == 1 && node.val > left[3] && node.val < right[2]) {
            return new int[]{left[0] + right[0] + 1, 1, Math.min(left[2], node.val), Math.max(right[3], node.val)};
        } else {
            return new int[]{Math.max(left[0], right[0]), 0};
        }
    }
}
