package leetcode.p1143;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp1 = new int[text2.length() + 1];
        int[] dp2 = new int[text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
            for (int j = 1; j < dp2.length; j++) {
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp2[j] = dp1[j - 1] + 1;
                } else {
                    dp2[j] = Math.max(dp1[j], dp2[j - 1]);
                }
            }
        }

        return dp2[text2.length()];
    }
}
