package offer.p47;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int maxValue(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int left = 0;
                if (col > 0) {
                    left = grid[row][col - 1];
                }
                int top = 0;
                if (row > 0) {
                    top = grid[row - 1][col];
                }
                grid[row][col] += Math.max(left, top);
                res = grid[row][col];
            }
        }
        return res;
    }
}
