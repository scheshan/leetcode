package leetcode.p108;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        int mid = l + ((r - l) >> 1);
        TreeNode res = new TreeNode(nums[mid]);
        res.left = build(nums, l, mid);
        res.right = build(nums, mid + 1, r);

        return res;
    }
}
