package l695;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1;

        int result = 1;

        result += dfs(grid, i - 1, j);
        result += dfs(grid, i + 1, j);
        result += dfs(grid, i, j - 1);
        result += dfs(grid, i, j + 1);

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][];
        grid[0] = new int[]{1, 1};
        grid[1] = new int[]{1, 0};

        new Solution().maxAreaOfIsland(grid);
    }
}
