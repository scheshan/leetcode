package leetcode.p153;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[l];

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= nums[r]) {
                res = Math.min(res, nums[mid]);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
