package leetcode.p72;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/10
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int cnt;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cnt = dp[i - 1][j - 1];
                } else {
                    cnt = dp[i - 1][j - 1] + 1;
                }
                cnt = Math.min(cnt, dp[i - 1][j] + 1);
                cnt = Math.min(cnt, dp[i][j - 1] + 1);
                dp[i][j] = cnt;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
