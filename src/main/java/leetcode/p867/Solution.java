package leetcode.p867;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];

        int row = 0;
        int col = 0;

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = matrix[row][col];
                row++;
                if (row == matrix.length) {
                    row = 0;
                    col++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }
}
