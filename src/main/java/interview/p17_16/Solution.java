package interview.p17_16;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int massage(int[] nums) {
        int[] dp = new int[2];

        for (int num : nums) {
            int n0 = dp[1];
            int n1 = dp[0] + num;
            dp[0] = Math.max(dp[0], n0);
            dp[1] = Math.max(dp[1], n1);
        }

        return Math.max(dp[0], dp[1]);
    }
}
