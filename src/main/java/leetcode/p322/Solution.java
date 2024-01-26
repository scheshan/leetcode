package leetcode.p322;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
