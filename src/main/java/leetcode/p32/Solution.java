package leetcode.p32;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }

            if (s.charAt(i - 1) == '(') {
                dp[i] = 2;
                if (i > 1 && s.charAt(i - 2) == ')') {
                    dp[i] += dp[i - 2];
                }
            } else if (dp[i - 1] > 0) {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                }
                if (i - dp[i] >= 0 && s.charAt(i - dp[i]) == ')') {
                    dp[i] += dp[i - dp[i]];
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
