package leetcode.p1143;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        int[] dp2 = new int[text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp2[j + 1] = dp[j] + 1;
                } else {
                    dp2[j + 1] = Math.max(dp[j + 1], dp2[j]);
                }
            }
            int[] t = dp;
            dp = dp2;
            dp2 = t;
        }

        return dp[text2.length()];
    }
}
