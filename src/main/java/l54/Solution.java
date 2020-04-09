package l54;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int total = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(total);

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (total > 0) {
            for (int i = left; i <= right && total > 0; i++) {
                res.add(matrix[top][i]);
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total > 0; i++) {
                res.add(matrix[i][right]);
                total--;
            }
            right--;
            for (int i = right; i >= left && total > 0; i--) {
                res.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total > 0; i--) {
                res.add(matrix[i][left]);
                total--;
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        };

        List<Integer> res = new Solution().spiralOrder(grid);
    }
}
