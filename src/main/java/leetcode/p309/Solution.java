package leetcode.p309;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            if (i > 1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][1] - prices[i]);
            }
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
