package leetcode.p72;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i < word2.length(); i++) {
            dp[i + 1] = i + 1;
        }
        int[] dp2 = new int[word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            dp2[0] = i + 1;

            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp2[j + 1] = dp[j];
                } else {
                    dp2[j + 1] = min(dp[j], dp2[j], dp[j + 1]) + 1;
                }
            }

            int[] t = dp;
            dp = dp2;
            dp2 = t;
        }

        return dp[word2.length()];
    }

    private int min(int... nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < res) {
                res = nums[i];
            }
        }

        return res;
    }
}
