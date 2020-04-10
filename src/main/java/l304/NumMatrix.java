package l304;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int t = matrix[i][j];
                if (i > 0) {
                    t += dp[i - 1][j];
                }
                if (j > 0) {
                    t += dp[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    t -= dp[i - 1][j - 1];
                }
                dp[i][j] = t;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null) {
            return 0;
        }

        int n = dp[row2][col2];
        if (row1 > 0) {
            n -= dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            n -= dp[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            n += dp[row1 - 1][col1 - 1];
        }
        return n;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int[]{5, 6, 3, 2, 1},
                new int[]{1, 2, 0, 1, 5},
                new int[]{4, 1, 0, 1, 7},
                new int[]{1, 0, 3, 0, 5}
        };

        new NumMatrix(grid).sumRegion(2, 1, 4, 3);
    }
}
