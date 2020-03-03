package l1008;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        TreeNode root = new TreeNode(nums[l]);
        int mid = findIndex(nums, root.val, l + 1, r);
        root.left = buildTree(nums, l + 1, mid);
        root.right = buildTree(nums, mid, r);
        return root;
    }

    private int findIndex(int[] nums, int n, int l, int r) {
        int i = l;
        for (; i < r; i++) {
            if (nums[i] > n) {
                return i;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2};
        TreeNode node = new Solution().bstFromPreorder(nums);
    }
}
