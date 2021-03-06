package l64;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/14
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        new Solution().minPathSum(new int[][]{new int[]{1, 2, 5}, new int[]{3, 2, 1}});
    }
}
