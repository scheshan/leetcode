package l279;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int x = new Solution().numSquares(7168);
        System.out.println(x);
    }
}
