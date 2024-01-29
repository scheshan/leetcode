package leetcode.p2265;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int averageOfSubtree(TreeNode root) {
        int[] arr = travel(root);

        return arr[2];
    }

    private int[] travel(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0, 0};
        }

        int[] left = travel(node.left);
        int[] right = travel(node.right);
        left[0] += right[0] + node.val;
        left[1] += right[1] + 1;
        left[2] += right[2];

        if (left[0] / left[1] == node.val) {
            left[2]++;
        }
        return left;
    }
}
