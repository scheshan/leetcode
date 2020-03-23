package l322;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/8
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                int ind = i + coin;
                if (ind < 0 || ind > amount) {
                    continue;
                }
                if (dp[ind] == Integer.MAX_VALUE) {
                    dp[ind] = dp[i] + 1;
                } else {
                    dp[ind] = Math.min(dp[ind], dp[i] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{2}, 3);
    }
}
