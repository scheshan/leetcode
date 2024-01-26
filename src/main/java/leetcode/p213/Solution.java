package leetcode.p213;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    private int[][] dp;

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        dp = new int[nums.length][2];

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int begin, int end) {
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 0;
        }

        dp[begin][0] = nums[begin];
        for (int i = begin + 1; i < end; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }

        return Math.max(dp[end - 1][0], dp[end - 1][1]);
    }
}
