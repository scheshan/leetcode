package leetcode.p2428;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution {

    public int maxSum(int[][] grid) {
        int res = Integer.MIN_VALUE;

        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[i].length; j++) {
                int n = grid[i - 2][j - 2] + grid[i - 2][j - 1] + grid[i - 2][j]
                        + grid[i - 1][j - 1]
                        + grid[i][j - 2] + grid[i][j - 1] + grid[i][j];
                res = Math.max(res, n);
            }
        }

        return res;
    }
}
