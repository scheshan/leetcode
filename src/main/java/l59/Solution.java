package l59;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int cur = 1;
        while (cur <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = cur++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = cur++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = cur++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = cur++;
            }
            left++;
        }

        return res;
    }
}
