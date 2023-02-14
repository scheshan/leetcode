package leetcode.p1582;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                rows[row] += mat[row][col];
                cols[col] += mat[row][col];
            }
        }

        int res = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 1 && rows[row] == 1 && cols[col] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
