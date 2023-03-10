package leetcode.p413;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/10
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;

        if (nums.length < 2) {
            return res;
        }

        int delta = nums[1] - nums[0];
        int cnt = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == delta) {
                cnt++;
            } else {
                delta = nums[i] - nums[i - 1];
                cnt = 0;
            }
            res += cnt;
        }

        return res;
    }
}
