package l643;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int cur = 0;
        int i = 0;
        int max = 0;
        for (; i < k; i++) {
            cur += nums[i];
        }
        max = cur;
        for (; i < nums.length; i++) {
            int left = i - k;

            cur = cur - nums[left] + nums[i];
            max = Math.max(cur, max);
        }

        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
    }
}
