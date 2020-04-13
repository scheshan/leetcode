package l1277;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int countSquares(int[][] matrix) {
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] += Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    }
                    res += matrix[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{0, 1, 1, 1},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 1, 1}
        };

        new Solution().countSquares(grid);
    }
}
