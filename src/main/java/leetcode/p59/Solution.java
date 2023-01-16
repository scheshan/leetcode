package leetcode.p59;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            res[i] = new int[n];
        }

        int cur = 1;
        int r1 = 0;
        int c1 = 0;
        int r2 = res.length - 1;
        int c2 = res[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                res[r1][i] = cur++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res[i][c2] = cur++;
            }
            if (r1 < r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res[r2][i] = cur++;
                }
            }
            if (c1 < c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res[i][c1] = cur++;
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
