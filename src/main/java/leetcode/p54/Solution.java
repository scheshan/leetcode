package leetcode.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1 < r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res.add(matrix[r2][i]);
                }
            }
            if (c1 < c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return res;
    }
}
