package l74;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int top = 0;
        int bottom = matrix.length - 1;

        int row = -1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (matrix[mid].length == 0) {
                top = mid + 1;
                continue;
            }
            int first = matrix[mid][0];
            int last = matrix[mid][matrix[mid].length - 1];
            if (last < target) {
                top = mid + 1;
            } else if (first > target) {
                bottom = mid - 1;
            } else {
                row = mid;
                break;
            }
        }

        if (row == -1) {
            return false;
        }

        int[] nums = matrix[row];
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return true;
            }
        }

        return false;
    }
}
