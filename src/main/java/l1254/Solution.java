package l1254;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[i].length - 1);
        }

        for (int j = 1; j < grid[0].length - 1; j++) {
            dfs(grid, 0, j);
        }
        for (int j = 1; j < grid[grid.length - 1].length - 1; j++) {
            dfs(grid, grid.length - 1, j);
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0) {
            return;
        }

        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
