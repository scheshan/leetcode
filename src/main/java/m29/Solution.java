package m29;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int total = matrix.length * matrix[0].length;
        int[] res = new int[total];

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int ind = 0;
        while (ind < total) {
            for (int i = left; i <= right && ind < total; i++) {
                res[ind++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom && ind < total; i++) {
                res[ind++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && ind < total; i--) {
                res[ind++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && ind < total; i--) {
                res[ind++] = matrix[i][left];
            }
            left++;
        }

        return res;
    }
}
