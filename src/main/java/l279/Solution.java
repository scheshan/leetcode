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

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j + i <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int x = new Solution().numSquares(7168);
        System.out.println(x);
    }
}
