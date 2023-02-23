package leetcode.p1254;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/23
 */
public class Solution {

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][grid[i].length - 1] == 0) {
                dfs(grid, i, grid[i].length - 1);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                dfs(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 0) {
                dfs(grid, grid.length - 1, i);
            }
        }


        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if (i != 0 && j != 0 && i != grid.length - 1 && j != grid[i].length - 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (grid[row][col] != 0) {
            return;
        }

        grid[row][col] = 1;
        if (row > 0) {
            dfs(grid, row - 1, col);
        }
        if (row < grid.length - 1) {
            dfs(grid, row + 1, col);
        }
        if (col > 0) {
            dfs(grid, row, col - 1);
        }
        if (col < grid[row].length - 1) {
            dfs(grid, row, col + 1);
        }
    }
}
