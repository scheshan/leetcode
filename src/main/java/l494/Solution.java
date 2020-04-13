package l494;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j - nums[i] >= 0) {
                        dp[i][j - nums[i]] += dp[i - 1][j];
                    }
                    if (j + nums[i] < dp[i].length) {
                        dp[i][j + nums[i]] += dp[i - 1][j];
                    }
                }
            }
        }

        return S <= 1000 ? dp[nums.length - 1][S + 1000] : 0;
    }
}
