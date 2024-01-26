package leetcode.p718;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;

        for (int i = 1; i < dp.length; i++) {
            int ind1 = i - 1;
            for (int j = 1; j < dp[i].length; j++) {
                int ind2 = j - 1;

                if (nums1[ind1] == nums2[ind2]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
