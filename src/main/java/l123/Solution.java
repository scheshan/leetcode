package l123;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length][3][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][1][1] = -prices[i];
                dp[i][2][1] = -prices[i];
                continue;
            }

            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        int res = 0;
        for (int i = 1; i <= 2; i++) {
            res = Math.max(dp[dp.length - 1][i][0], res);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0});
        System.out.println(res);
    }
}
