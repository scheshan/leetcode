package l343;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        return count(n, dp);
    }

    private int count(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(count(i, dp) * count(n - i, dp), res);
        }

        dp[n] = res;
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().integerBreak(10);
        System.out.println(res);
    }
}
