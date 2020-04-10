package l1143;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int n = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    n = dp[i][j] + 1;
                } else {
                    n = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
                dp[i + 1][j + 1] = n;
                res = Math.max(res, n);
            }
        }

        return res;
    }
}
