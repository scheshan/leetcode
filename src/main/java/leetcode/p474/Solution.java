package leetcode.p474;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int n0 = 0;
            int n1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    n1++;
                } else {
                    n0++;
                }
            }

            for (int i = m; i >= n0; i--) {
                for (int j = n; j >= n1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - n0][j - n1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
