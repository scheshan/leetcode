package l5372;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int minStartValue(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }

        return res >= 1 ? 0 : (1 - res);
    }
}
