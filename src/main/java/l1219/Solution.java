package l1219;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    int max = 0;

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int i, int j, int cur) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] <= 0) {
            return;
        }

        cur += grid[i][j];
        max = Math.max(max, cur);

        grid[i][j] *= -1;
        dfs(grid, i - 1, j, cur);
        dfs(grid, i + 1, j, cur);
        dfs(grid, i, j - 1, cur);
        dfs(grid, i, j + 1, cur);

        grid[i][j] *= -1;
    }
}
