package l300;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/14
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
