package l240;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[i].length) {
            int n = matrix[i][j];
            if (n == target) {
                return true;
            } else if (n > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
