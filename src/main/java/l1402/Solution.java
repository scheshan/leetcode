package l1402;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int[] dp = new int[satisfaction.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < satisfaction.length; i++) {
            for (int j = i; j >= 1; j--) {
                dp[j] = Math.max(
                        dp[j - 1] + satisfaction[i] * (j + 1),
                        dp[j]
                );
            }
            dp[0] = satisfaction[i];
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().maxSatisfaction(new int[]{-1, -8, 0, 5, -7});
    }
}
