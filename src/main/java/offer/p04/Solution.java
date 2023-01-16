package offer.p04;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[row].length) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
