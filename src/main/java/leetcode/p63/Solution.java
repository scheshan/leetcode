package leetcode.p63;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        for (int row = 0; row < obstacleGrid.length; row++) {
            for (int col = 0; col < obstacleGrid[row].length; col++) {
                if (row == 0 && col == 0) {
                    dp[col] = obstacleGrid[0][0] == 1 ? 0 : 1;
                } else if (row == 0) {
                    dp[col] = obstacleGrid[row][col] == 1 ? 0 : dp[col - 1];
                } else if (col == 0) {
                    dp[col] = obstacleGrid[row][col] == 1 ? 0 : dp[col];
                } else {
                    dp[col] = obstacleGrid[row][col] == 1 ? 0 : dp[col - 1] + dp[col - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
