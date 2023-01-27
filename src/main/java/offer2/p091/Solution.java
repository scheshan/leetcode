package offer2.p091;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minCost(int[][] costs) {
        int[] dp = new int[3];

        for (int[] cost : costs) {
            int n0 = Math.min(dp[1], dp[2]) + cost[0];
            int n1 = Math.min(dp[0], dp[2]) + cost[1];
            int n2 = Math.min(dp[0], dp[1]) + cost[2];

            dp[0] = n0;
            dp[1] = n1;
            dp[2] = n2;
        }

        return Math.min(dp[2], Math.min(dp[0], dp[1]));
    }
}
