package leetcode.p63;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    int num = dp[j];
                    if (j > 0) {
                        num += dp[j - 1];
                    }
                    dp[j] = num;
                }
            }
        }

        return dp[dp.length - 1];
    }
}
