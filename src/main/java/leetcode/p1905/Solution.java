package leetcode.p1905;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid2, i, j, grid1)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int row, int col, int[][] g) {
        if (grid[row][col] == 0) {
            return true;
        }

        grid[row][col] = 0;
        boolean res = g[row][col] == 1;
        boolean b;
        if (row > 0) {
            b = dfs(grid, row - 1, col, g);
            res = res && b;
        }
        if (row < grid.length - 1) {
            b = dfs(grid, row + 1, col, g);
            res = res && b;
        }
        if (col > 0) {
            b = dfs(grid, row, col - 1, g);
            res = res && b;
        }
        if (col < grid[row].length - 1) {
            b = dfs(grid, row, col + 1, g);
            res = res && b;
        }
        return res;
    }
}
