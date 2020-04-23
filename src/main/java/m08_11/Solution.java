package m08_11;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/13
 */
public class Solution {

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int[] coins = new int[]{1, 5, 10, 25};
        for (int c : coins) {
            for (int i = c; i <= n; i++) {
                dp[i] += dp[i - c];
                dp[i] %= 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int res = new Solution().waysToChange(10);
        System.out.println(res);
    }
}
