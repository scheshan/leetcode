package leetcode.p1493;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, res = 0, zero = 0;

        while (r < nums.length) {
            if (nums[r++] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[l++] == 0) {
                    zero--;
                }
            }
            res = Math.max(res, r - l - Math.max(zero, 1));
        }

        return res;
    }
}
