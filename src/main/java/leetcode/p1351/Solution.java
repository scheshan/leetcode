package leetcode.p1351;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int countNegatives(int[][] grid) {
        int res = 0;

        int row = grid.length - 1;
        int col = 0;

        while (row >= 0 && col < grid[row].length) {
            if (grid[row][col] >= 0) {
                col++;
            } else {
                res += grid[row].length - col;
                row--;
            }
        }
        return res;
    }
}
