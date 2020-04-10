package l1314;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] dp = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int t = mat[i][j];
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
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[i][j] = count(dp, i - K, j - K, i + K, j + K);
            }
        }

        return res;
    }

    private int count(int[][] dp, int row1, int col1, int row2, int col2) {
        row1 = row(dp, row1);
        row2 = row(dp, row2);
        col1 = col(dp, col1);
        col2 = col(dp, col2);

        int t = dp[row2][col2];
        if (row1 > 0) {
            t -= dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            t -= dp[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            t += dp[row1 - 1][col1 - 1];
        }

        return t;
    }

    private int row(int[][] dp, int row) {
        if (row < 0) {
            row = 0;
        } else if (row >= dp.length) {
            row = dp.length - 1;
        }
        return row;
    }

    private int col(int[][] dp, int col) {
        if (col < 0) {
            col = 0;
        } else if (col >= dp[0].length) {
            col = dp[0].length - 1;
        }
        return col;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        new Solution().matrixBlockSum(mat, 1);
    }
}
