package leetcode.p1706;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        int[][] visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = dfs(grid, 0, i, visit);
            if (res[i] > 0) {
                res[i]--;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col, int[][] visit) {
        if (visit[row][col] != 0) {
            return visit[row][col];
        }
        if (grid[row][col] == 1) {
            if (col >= grid[row].length - 1 || grid[row][col + 1] == -1) {
                visit[row][col] = -1;
            } else {
                if (row == grid.length - 1) {
                    visit[row][col] = col + 2;
                } else {
                    visit[row][col] = dfs(grid, row + 1, col + 1, visit);
                }
            }
        } else {
            if (col == 0 || grid[row][col - 1] == 1) {
                visit[row][col] = -1;
            } else {
                if (row == grid.length - 1) {
                    visit[row][col] = col;
                } else {
                    visit[row][col] = dfs(grid, row + 1, col - 1, visit);
                }
            }
        }
        return visit[row][col];
    }
}
