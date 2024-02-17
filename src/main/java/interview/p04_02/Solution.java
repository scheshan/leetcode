package interview.p04_02;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + ((r - l) >> 1);
        TreeNode res = new TreeNode(nums[mid]);
        res.left = build(nums, l, mid - 1);
        res.right = build(nums, mid + 1, r);

        return res;
    }
}
