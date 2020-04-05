package l931;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int n = A[i - 1][j];
                if (j > 0) {
                    n = Math.min(n, A[i - 1][j - 1]);
                }
                if (j < A[i - 1].length - 1) {
                    n = Math.min(n, A[i - 1][j + 1]);
                }
                A[i][j] += n;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < A[A.length - 1].length; j++) {
            res = Math.min(res, A[A.length - 1][j]);
        }

        return res;
    }
}
