package leetcode.p583;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[] dp1 = new int[word2.length() + 1];
        int[] dp2 = new int[word2.length() + 1];
        for (int i = 1; i < dp2.length; i++) {
            dp2[i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
            dp2[0] = i;

            for (int j = 1; j < dp2.length; j++) {
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp2[j] = dp1[j - 1];
                } else {
                    dp2[j] = Math.min(dp1[j] + 1, dp2[j - 1] + 1);
                }
            }
        }
        return dp2[word2.length()];
    }
}
