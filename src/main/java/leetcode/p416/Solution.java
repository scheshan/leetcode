package leetcode.p416;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
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

        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = total; j >= num; j--) {
                dp[j] += dp[j - num];
                if (j == total && dp[j] > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
