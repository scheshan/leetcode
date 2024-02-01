package leetcode.p48;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int r1 = 0, r2 = matrix.length - 1;

        while (r1 < r2) {
            for (int i = 0; i < r2 - r1; i++) {
                int t = matrix[r1][r1 + i];
                matrix[r1][r1 + i] = matrix[r2 - i][r1];
                matrix[r2 - i][r1] = matrix[r2][r2 - i];
                matrix[r2][r2 - i] = matrix[r1 + i][r2];
                matrix[r1 + i][r2] = t;
            }
            r1++;
            r2--;
        }
    }
}
