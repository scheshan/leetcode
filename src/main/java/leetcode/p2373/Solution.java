package leetcode.p2373;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid[0].length - 2];

        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] = Integer.MIN_VALUE;

                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        res[row][col] = Math.max(res[row][col], grid[r][c]);
                    }
                }
            }
        }
        return res;
    }
}
