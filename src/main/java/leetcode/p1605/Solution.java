package leetcode.p1605;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int n = Math.min(rowSum[i], colSum[j]);
                res[i][j] = n;
                rowSum[i] -= n;
                colSum[j] -= n;
            }
        }

        return res;
    }
}
