package l474;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/22
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        int res = 0;
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
                    dp[i][j] = Integer.max(dp[i - n0][j - n1] + 1, dp[i][j]);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }
}
