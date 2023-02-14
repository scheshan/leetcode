package leetcode.p643;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = 0;

        double res = Double.MIN_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r++];
            if (r - l > k) {
                sum -= nums[l++];
            }

            if (r - l == k) {
                if (l == 0) {
                    res = sum * 1.0 / k;
                } else {
                    res = Math.max(res, sum * 1.0 / k);
                }
            }
        }
        return res;
    }
}
