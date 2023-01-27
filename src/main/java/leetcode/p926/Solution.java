package leetcode.p926;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minFlipsMonoIncr(String s) {
        int[] dp = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int n0, n1;
            if (ch == '0') {
                n0 = dp[0];
                n1 = Math.min(dp[0], dp[1]) + 1;
            } else {
                n0 = dp[0] + 1;
                n1 = Math.min(dp[0], dp[1]);
            }
            dp[0] = n0;
            dp[1] = n1;
        }
        return Math.min(dp[0], dp[1]);
    }
}
