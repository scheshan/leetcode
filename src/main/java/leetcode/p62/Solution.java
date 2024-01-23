package leetcode.p62;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int num = dp[j - 1] + dp[j];
                dp[j] = num;
            }
        }

        return dp[dp.length - 1];
    }
}
