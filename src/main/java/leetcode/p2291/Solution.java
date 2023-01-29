package leetcode.p2291;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int maximumProfit(int[] present, int[] future, int budget) {
        int[] dp = new int[budget + 1];
        for (int i = 0; i < present.length; i++) {
            int cost = present[i];
            int value = future[i] - cost;
            if (value < 0) {
                continue;
            }

            for (int j = budget; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + value);
            }
        }
        return dp[budget];
    }
}
