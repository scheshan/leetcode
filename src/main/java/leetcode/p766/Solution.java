package leetcode.p766;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int r = 1;
            int c = col + 1;

            while (r < matrix.length && c < matrix[r].length) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
                r++;
                c++;
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            int r = row + 1;
            int c = 1;

            while (r < matrix.length && c < matrix[r].length) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
                r++;
                c++;
            }
        }

        return true;
    }
}
