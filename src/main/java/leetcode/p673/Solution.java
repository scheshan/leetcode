package leetcode.p673;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/6
 */
public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int max = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i]++;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                res = cnt[i];
            } else if (dp[i] == max) {
                res += cnt[i];
            }
        }

        return res;
    }
}
