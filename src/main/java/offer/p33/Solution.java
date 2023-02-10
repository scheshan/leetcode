package offer.p33;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return valid(postorder, 0, postorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(int[] nums, int l, int r, int min, int max) {
        if (l >= r) {
            if (l > r) {
                return true;
            }
            return nums[l] <= max && nums[l] >= min;
        }

        int mid = r;
        while (mid >= l && nums[mid] >= nums[r]) {
            mid--;
        }

        return valid(nums, l, mid, min, nums[r]) && valid(nums, mid + 1, r - 1, nums[r], max);
    }
}
