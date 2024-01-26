package leetcode.p123;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        int[] dp2 = new int[4];

        dp[0] = -prices[0];
        dp[2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp2[0] = Math.max(dp[0], -prices[i]);
            dp2[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp2[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp2[3] = Math.max(dp[3], dp[2] + prices[i]);

            int[] t = dp2;
            dp2 = dp;
            dp = t;
        }

        return Math.max(dp[1], dp[3]);
    }
}
