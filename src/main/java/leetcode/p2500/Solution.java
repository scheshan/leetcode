package leetcode.p2500;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int deleteGreatestValue(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            Arrays.sort(grid[row]);
        }

        int res = 0;
        for (int col = grid[0].length - 1; col >= 0; col--) {
            int max = 0;
            for (int row = 0; row < grid.length; row++) {
                max = Math.max(max, grid[row][col]);
            }
            res += max;
        }

        return res;
    }
}
