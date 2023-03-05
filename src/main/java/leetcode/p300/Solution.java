package leetcode.p300;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/6
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
