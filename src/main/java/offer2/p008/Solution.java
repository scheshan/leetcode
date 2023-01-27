package offer2.p008;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;

        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < nums.length) {
            cur += nums[r];

            while (cur >= target) {
                res = Math.min(res, r - l + 1);
                cur -= nums[l++];
            }
            r++;
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
