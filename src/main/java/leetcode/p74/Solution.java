package leetcode.p74;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;

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
