package l583;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/20
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[] dp1 = new int[word2.length() + 1];
        int[] dp2 = new int[word2.length() + 1];

        int lcs = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp2[j] = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1] + 1;
                }
                dp2[j] = Math.max(dp2[j], dp1[j]);
                dp2[j] = Math.max(dp2[j], dp2[j - 1]);

                lcs = Math.max(lcs, dp2[j]);
            }
            System.arraycopy(dp2, 0, dp1, 0, dp2.length);
        }

        return word1.length() + word2.length() - lcs * 2;
    }
}
