package leetcode.p2133;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public boolean checkValid(int[][] matrix) {
        boolean[][] rows = new boolean[matrix.length][matrix.length + 1];
        boolean[][] cols = new boolean[matrix.length][matrix.length + 1];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int num = matrix[row][col];
                if (rows[row][num] || cols[col][num]) {
                    return false;
                }
                rows[row][num] = true;
                cols[col][num] = true;
            }
        }
        return true;
    }
}
