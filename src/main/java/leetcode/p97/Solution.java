package leetcode.p97;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int ind = i + j - 1;

                if (i > 0 && s1.charAt(i - 1) == s3.charAt(ind)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(ind)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
