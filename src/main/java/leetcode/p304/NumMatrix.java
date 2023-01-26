package leetcode.p304;

/**
 * NumMatrix
 *
 * @author heshan
 * @date 2023/1/26
 */
public class NumMatrix {

    private int[][] pre;

    public NumMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 && col == 0) {
                    continue;
                } else if (row == 0) {
                    matrix[row][col] += matrix[row][col - 1];
                } else if (col == 0) {
                    matrix[row][col] += matrix[row - 1][col];
                } else {
                    matrix[row][col] += matrix[row - 1][col] + matrix[row][col - 1] - matrix[row - 1][col - 1];
                }
            }
        }
        pre = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = pre[row2][col2];
        if (row1 > 0) {
            res -= pre[row1 - 1][col2];
        }
        if (col1 > 0) {
            res -= pre[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            res += pre[row1 - 1][col1 - 1];
        }
        return res;
    }
}
