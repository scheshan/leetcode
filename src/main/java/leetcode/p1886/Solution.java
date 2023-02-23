package leetcode.p1886;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/23
 */
public class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {
        if (valid(mat, target)) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            rotate(mat);
            if (valid(mat, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean valid(int[][] g1, int[][] g2) {
        for (int row = 0; row < g1.length; row++) {
            for (int col = 0; col < g2[row].length; col++) {
                if (g1[row][col] != g2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[r2].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = r2 - 1; i >= r1; i--) {
                swap(matrix, i, c1, r2, i - r1 + c1);
            }
            for (int i = c2 - 1; i >= c1; i--) {
                swap(matrix, r2, i, r1 - i + c2, c2);
            }
            if (r1 < r2) {
                for (int i = r1 + 1; i <= r2; i++) {
                    swap(matrix, i, c2, r1, c1 + i - r1);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
    }

    private void swap(int[][] grid, int r1, int c1, int r2, int c2) {
        int t = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = t;
    }
}
