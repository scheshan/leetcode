package l416;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/11
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

        for (int num : nums) {
            for (int j = total; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[total];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}
