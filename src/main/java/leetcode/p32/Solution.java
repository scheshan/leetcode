package leetcode.p32;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }

            int pre = i - 1;
            if (pre >= 0 && s.charAt(pre) == ')' && dp[pre] > 0) {
                pre = i - dp[pre] - 1;
            }
            if (pre >= 0 && s.charAt(pre) == '(') {
                dp[i] = i - pre + 1;
                if (pre - 1 >= 0 && dp[pre - 1] > 0) {
                    dp[i] += dp[pre - 1];
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
