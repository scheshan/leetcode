package leetcode.p654;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int ind = maxIndex(nums, l, r);
        TreeNode res = new TreeNode(nums[ind]);
        res.left = build(nums, l, ind - 1);
        res.right = build(nums, ind + 1, r);
        return res;
    }

    private int maxIndex(int[] arr, int l, int r) {
        int max = arr[l];
        int res = l;

        for (int i = l + 1; i <= r; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }

        return res;
    }
}
