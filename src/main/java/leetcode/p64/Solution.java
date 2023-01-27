package leetcode.p64;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0 && col == 0) {
                    continue;
                } else if (row == 0) {
                    grid[row][col] += grid[row][col - 1];
                } else if (col == 0) {
                    grid[row][col] += grid[row - 1][col];
                } else {
                    grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
