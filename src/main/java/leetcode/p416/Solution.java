package leetcode.p416;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if ((total & 1) == 1) {
            return false;
        }

        total >>= 1;

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = total; j >= 1; j--) {
                if (j >= nums[i]) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }

        return dp[total];
    }
}
