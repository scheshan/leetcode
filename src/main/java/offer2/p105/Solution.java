package offer2.p105;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                res = Math.max(dfs(grid, row, col), res);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] != 1) {
            return 0;
        }

        int res = 1;
        grid[row][col] = 0;

        if (row > 0) {
            res += dfs(grid, row - 1, col);
        }
        if (row < grid.length - 1) {
            res += dfs(grid, row + 1, col);
        }
        if (col > 0) {
            res += dfs(grid, row, col - 1);
        }
        if (col < grid[row].length - 1) {
            res += dfs(grid, row, col + 1);
        }
        return res;
    }
}
