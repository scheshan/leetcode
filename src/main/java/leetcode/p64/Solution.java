package leetcode.p64;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        int pre = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = pre + grid[0][i];
            pre = dp[i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                int left = Integer.MAX_VALUE;
                if (j > 0) {
                    left = dp[j - 1];
                }
                int top = dp[j];
                dp[j] = Math.min(left, top) + grid[i][j];
            }
        }

        return dp[dp.length - 1];
    }
}
