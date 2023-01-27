package leetcode.p329;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    private int res;

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                dfs(matrix, row, col, dp);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col, int[][] dp) {
        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        int res = 1;
        int num = grid[row][col];

        if (row > 0 && num > grid[row - 1][col]) {
            res = Math.max(res, dfs(grid, row - 1, col, dp) + 1);
        }
        if (row < grid.length - 1 && num > grid[row + 1][col]) {
            res = Math.max(res, dfs(grid, row + 1, col, dp) + 1);
        }
        if (col > 0 && num > grid[row][col - 1]) {
            res = Math.max(res, dfs(grid, row, col - 1, dp) + 1);
        }
        if (col < grid[row].length - 1 && num > grid[row][col + 1]) {
            res = Math.max(res, dfs(grid, row, col + 1, dp) + 1);
        }

        dp[row][col] = res;
        this.res = Math.max(this.res, res);
        return res;
    }
}
