package l486;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        Tuple[][] dp = new Tuple[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = new Tuple(0, 0);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j].first = nums[i];
            }
        }

        for (int j = 1; j < nums.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                //dp[i][j].first = max(nums[i]+dp[i+1][j].second,  nums[j]+dp[i][j-1].second)
                int left = nums[i] + dp[i + 1][j].second;
                int right = nums[j] + dp[i][j - 1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }

        return dp[0][nums.length - 1].first >= dp[0][nums.length - 1].second;
    }

    private class Tuple {

        int first;

        int second;

        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        boolean res = new Solution().PredictTheWinner(new int[]{2, 2, 454, 2, 2});
        System.out.println(res);
    }
}
