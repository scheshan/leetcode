package interview.p04_02;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }
}
