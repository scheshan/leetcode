package leetcode.p1020;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[i].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, 0, i);
            dfs(grid, grid.length - 1, i);
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int res = 1;

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
