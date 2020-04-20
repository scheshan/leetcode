package l32;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] += dp[i - 2];
                    }
                } else {
                    if (dp[i - 1] > 0) {
                        int j = i - dp[i - 1] - 1;
                        if (j >= 0 && s.charAt(j) == '(') {
                            dp[i] += dp[i - 1] + 2;
                            if (j > 0) {
                                dp[i] += dp[j - 1];
                            }
                        }
                    }
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().longestValidParentheses(")()())");
        System.out.println(res);
    }
}
