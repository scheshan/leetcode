package leetcode.p209;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r++];

            while (sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
