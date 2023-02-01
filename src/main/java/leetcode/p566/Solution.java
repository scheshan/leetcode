package leetcode.p566;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int row = 0;
        int col = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[row][col++] = mat[i][j];
                if (col == res[row].length) {
                    col = 0;
                    row++;
                }
            }
        }
        return res;
    }
}
