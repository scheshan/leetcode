package leetcode.p2022;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }

        int[][] res = new int[m][n];
        int ind = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                res[row][col] = original[ind++];
            }
        }
        return res;
    }
}
