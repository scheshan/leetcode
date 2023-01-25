package leetcode.p1430;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/25
 */
public class Solution {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode node, int[] arr, int ind) {
        if (node == null || node.val != arr[ind]) {
            return false;
        }

        if (ind == arr.length - 1) {
            return node.left == null && node.right == null;
        }

        return isValid(node.left, arr, ind + 1) || isValid(node.right, arr, ind + 1);
    }
}
