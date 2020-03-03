package l654;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private int maxIndex(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }

        int max = Integer.MIN_VALUE;
        int index = -1;

        while (l <= r) {
            int n = nums[l];
            if (n > max) {
                max = n;
                index = l;
            }
            l++;
        }

        return index;
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = maxIndex(nums, l, r);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, l, mid - 1);
        node.right = buildTree(nums, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
