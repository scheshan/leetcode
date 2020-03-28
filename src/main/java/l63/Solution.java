package l63;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        obstacleGrid[i][j] = 1;
                    } else {
                        if (i > 0) {
                            obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                        }
                        if (j > 0) {
                            obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                        }
                    }
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        new Solution().uniquePathsWithObstacles(new int[][]{
                new int[]{1},
                new int[]{0}
        });
    }
}
