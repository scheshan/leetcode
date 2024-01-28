package leetcode.p198;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int rob(int[] nums) {
        int y = 0, n = 0;

        for (int i = 0; i < nums.length; i++) {
            int y1 = n + nums[i];
            int n1 = Math.max(y, n);

            y = y1;
            n = n1;
        }

        return Math.max(y, n);
    }
}
