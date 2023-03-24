package leetcode.p2016;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/24
 */
public class Solution {

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int res = -1;

        for (int i = 1; i < nums.length; i++) {
            if (min < nums[i]) {
                res = Math.max(res, nums[i] - min);
            } else {
                min = nums[i];
            }
        }

        return res;
    }
}
