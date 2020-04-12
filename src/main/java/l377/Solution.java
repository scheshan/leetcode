package l377;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/11
 */
public class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                int j = i - num;
                if (j >= 0) {
                    dp[i] += dp[j];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        new Solution().combinationSum4(new int[]{1, 2, 3}, 4);
    }
}
