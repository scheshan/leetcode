package leetcode.p2265;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    private int res;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        int sum = node.val;
        int total = 1;
        if (node.left != null) {
            int[] arr = dfs(node.left);
            sum += arr[0];
            total += arr[1];
        }
        if (node.right != null) {
            int[] arr = dfs(node.right);
            sum += arr[0];
            total += arr[1];
        }

        if (node.val == sum / total) {
            res++;
        }
        return new int[]{sum, total};
    }
}
