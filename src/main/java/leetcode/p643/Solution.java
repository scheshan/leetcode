package leetcode.p643;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        Double res = null;

        int l = 0, r = 0;
        double total = 0;
        while (r < nums.length) {
            total += nums[r++];

            if (r - l > k) {
                total -= nums[l++];
            }
            if (r - l == k) {
                if (res == null || total / k > res) {
                    res = total / k;
                }
            }
        }

        return res;
    }
}
