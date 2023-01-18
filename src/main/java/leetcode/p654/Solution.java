package leetcode.p654;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        int max = -1;
        int ind = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ind = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = buildTree(nums, l, ind);
        node.right = buildTree(nums, ind + 1, r);
        return node;
    }
}
