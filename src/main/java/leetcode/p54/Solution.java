package leetcode.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/31
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        int row1 = 0, col1 = 0, row2 = matrix.length - 1, col2 = matrix[row2].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int col = col1; col <= col2; col++) {
                res.add(matrix[row1][col]);
            }
            row1++;

            for (int row = row1; row <= row2 && row1 <= row2 && col1 <= col2; row++) {
                res.add(matrix[row][col2]);
            }
            col2--;

            for (int col = col2; col >= col1 && row1 <= row2 && col1 <= col2; col--) {
                res.add(matrix[row2][col]);
            }
            row2--;

            for (int row = row2; row >= row1 && row2 >= row1 && col1 <= col2; row--) {
                res.add(matrix[row][col1]);
            }
            col1++;
        }

        return res;
    }
}
