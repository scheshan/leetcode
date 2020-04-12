package l322;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/8
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int d = Integer.MAX_VALUE;
            for (int coin : coins) {
                int j = i - coin;
                if (j >= 0) {
                    if (j == 0) {
                        d = Math.min(d, 1);
                    } else if (dp[j] > 0) {
                        d = Math.min(d, dp[j] + 1);
                    }
                }
            }
            dp[i] = d == Integer.MAX_VALUE ? 0 : d;
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{1}, 0);
    }
}
