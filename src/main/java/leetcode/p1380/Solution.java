package leetcode.p1380;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] min = new int[matrix.length];
        int[] max = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (min[row] == 0) {
                    min[row] = matrix[row][col];
                }
                min[row] = Math.min(min[row], matrix[row][col]);
                if (max[col] == 0) {
                    max[col] = matrix[row][col];
                }
                max[col] = Math.max(max[col], matrix[row][col]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < max.length; j++) {
                if (min[i] == max[j]) {
                    res.add(min[i]);
                }
            }
        }
        return res;
    }
}
