package leetcode.p59;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/25
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        int ind = 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int col = c1; col <= c2; col++) {
                matrix[r1][col] = ind++;
            }
            r1++;

            if (r1 <= r2 && c1 <= c2) {
                for (int row = r1; row <= r2; row++) {
                    matrix[row][c2] = ind++;
                }
            }
            c2--;

            if (r1 <= r2 && c1 <= c2) {
                for (int col = c2; col >= c1; col--) {
                    matrix[r2][col] = ind++;
                }
            }
            r2--;

            if (r1 <= r2 && c1 <= c2) {
                for (int row = r2; row >= r1; row--) {
                    matrix[row][c1] = ind++;
                }
            }
            c1++;
        }

        return matrix;
    }
}
