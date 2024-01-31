package leetcode.p300;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/31
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int res = 1;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int v = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    v = Math.max(v, dp[j] + 1);
                }
            }
            dp[i] = v;
            res = Math.max(res, v);
        }

        return res;
    }
}
