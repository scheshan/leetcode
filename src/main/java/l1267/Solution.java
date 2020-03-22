package l1267;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int countServers(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int servers = dfs(grid, i, j);
                    if (servers > 1) {
                        res += servers;
                    }
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }

        int res = grid[i][j];
        grid[i][j] = -1;

        for (int z = 0; z < grid.length; z++) {
            if (z == i) {
                continue;
            }

            res += dfs(grid, z, j);
        }
        for (int z = 0; z < grid[i].length; z++) {
            if (z == j) {
                continue;
            }

            res += dfs(grid, i, z);
        }

        return res;
    }
}
