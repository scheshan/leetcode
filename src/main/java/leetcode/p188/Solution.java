package leetcode.p188;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = -prices[0];
        }

        int[][] dp2 = new int[k + 1][2];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp2[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp2[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
            int[][] t = dp;
            dp = dp2;
            dp2 = t;
        }

        int res = dp[k][1];

        return res;
    }
}
