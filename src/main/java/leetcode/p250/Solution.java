package leetcode.p250;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    int res;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int min = node.val;
        int max = node.val;

        if (left != null) {
            min = Math.min(min, left[0]);
            max = Math.max(max, left[1]);
        }
        if (right != null) {
            min = Math.min(min, right[0]);
            max = Math.max(max, right[1]);
        }

        if (min == max) {
            res++;
        }
        return new int[]{min, max};
    }
}
