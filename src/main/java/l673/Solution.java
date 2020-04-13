package l673;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            int n = 1;
            int c = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > n) {
                        c = count[j];
                        n = dp[j] + 1;
                    } else if (dp[j] + 1 == n) {
                        c += count[j];
                    }
                }
            }
            dp[i] = n;
            count[i] = c;
        }

        int maxNum = -1;
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxNum) {
                maxNum = dp[i];
                res = count[i];
            } else if (dp[i] == maxNum) {
                res += count[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        System.out.println(res);
    }
}
