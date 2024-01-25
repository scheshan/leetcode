package leetcode.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/25
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        while (r1 <= r2 && c1 <= c2) {
            for (int col = c1; col <= c2; col++) {
                res.add(matrix[r1][col]);
            }
            r1++;

            if (r1 <= r2 && c1 <= c2) {
                for (int row = r1; row <= r2; row++) {
                    res.add(matrix[row][c2]);
                }
            }
            c2--;

            if (r1 <= r2 && c1 <= c2) {
                for (int col = c2; col >= c1; col--) {
                    res.add(matrix[r2][col]);
                }
            }
            r2--;

            if (r1 <= r2 && c1 <= c2) {
                for (int row = r2; row >= r1; row--) {
                    res.add(matrix[row][c1]);
                }
            }
            c1++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(
                new int[][]{
                        {7},
                        {9},
                        {6}
                }
        ));
    }
}
