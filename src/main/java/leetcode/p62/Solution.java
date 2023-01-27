package leetcode.p62;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }
        return dp[n - 1];
    }
}
