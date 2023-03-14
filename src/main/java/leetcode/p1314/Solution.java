package leetcode.p1314;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int n = mat[i][j];
                if (i > 0) {
                    n += mat[i - 1][j];
                }
                if (j > 0) {
                    n += mat[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    n -= mat[i - 1][j - 1];
                }
                mat[i][j] = n;
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(mat.length - 1, i + k);
                int c2 = Math.min(mat[0].length - 1, j + k);

                int n = mat[r2][c2];
                if (r1 > 0) {
                    n -= mat[r1 - 1][c2];
                }
                if (c1 > 0) {
                    n -= mat[r2][c1 - 1];
                }
                if (r1 > 0 && c1 > 0) {
                    n += mat[r1 - 1][c1 - 1];
                }
                res[i][j] = n;
            }
        }

        return res;
    }
}
