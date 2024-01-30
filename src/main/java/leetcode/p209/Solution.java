package leetcode.p209;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int cnt = 0, res = 0;

        int l = 0, r = 0;
        while (r < nums.length) {
            cnt += nums[r++];

            while (cnt >= target) {
                if (res == 0) {
                    res = r - l;
                } else {
                    res = Math.min(res, r - l);
                }

                cnt -= nums[l++];
            }
        }

        return res;
    }
}
