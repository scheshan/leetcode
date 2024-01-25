package leetcode.p343;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }

        int res = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
