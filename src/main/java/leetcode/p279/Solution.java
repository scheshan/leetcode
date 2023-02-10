package leetcode.p279;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            int num = i * i;
            for (int j = num; j <= n; j++) {
                if (i == 1) {
                    dp[j] = dp[j - num] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - num] + 1);
                }
            }
        }
        return dp[n];
    }
}
