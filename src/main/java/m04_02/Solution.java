package m04_02;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, l, mid);
        node.right = buildTree(nums, mid + 1, r);
        return node;
    }
}
