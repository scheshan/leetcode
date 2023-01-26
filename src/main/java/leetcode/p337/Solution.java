package leetcode.p337;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int rob(TreeNode root) {
        int[] state = dfs(root);
        return Math.max(state[0], state[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int s0 = left[1] + right[1] + root.val;
        int s1 = left[0] + right[0];
        s1 = Math.max(s1, left[0] + right[1]);
        s1 = Math.max(s1, left[1] + right[0]);
        s1 = Math.max(s1, left[1] + right[1]);
        return new int[]{s0, s1};
    }
}
