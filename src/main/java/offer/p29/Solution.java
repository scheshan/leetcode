package offer.p29;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int ind = 0;

        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                res[ind++] = matrix[r1][i];
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res[ind++] = matrix[i][c2];
            }
            if (r1 < r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res[ind++] = matrix[r2][i];
                }
            }
            if (c1 < c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res[ind++] = matrix[i][c1];
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
