package l1380;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int n = matrix[i][j];
                if (n == row[i] && n == col[j]) {
                    res.add(n);
                }
            }
        }
        return res;
    }
}
