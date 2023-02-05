package leetcode.p2482;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int[][] onesMinusZeros(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    rows[row]++;
                    cols[col]++;
                } else {
                    rows[row]--;
                    cols[col]--;
                }
            }
        }

        int[][] res = new int[rows.length][cols.length];
        for (int row = 0; row < rows.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                res[row][col] = rows[row] + cols[col];
            }
        }
        return res;
    }
}
