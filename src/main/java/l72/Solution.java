package l72;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/22
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, dp[i + 1][j] + 1);
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1] + 1);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        int res = new Solution().minDistance("intention", "execution");
        System.out.println(res);
    }
}
