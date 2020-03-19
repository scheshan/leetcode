package m10_09;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length) {
            int v = matrix[i][j];
            if (v == target) {
                return true;
            } else if (v < target) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }
}
