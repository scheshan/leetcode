package offer.p47;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int maxValue(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row > 0 && col > 0) {
                    grid[row][col] += Math.max(grid[row - 1][col], grid[row][col - 1]);
                } else if (row > 0) {
                    grid[row][col] += grid[row - 1][col];
                } else if (col > 0) {
                    grid[row][col] += grid[row][col - 1];
                }
                res = grid[row][col];
            }
        }
        return res;
    }
}
