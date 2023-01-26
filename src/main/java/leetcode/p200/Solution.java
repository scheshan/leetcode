package leetcode.p200;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
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
