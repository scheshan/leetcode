package leetcode.p910;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int smallestRangeII(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int res = nums[nums.length - 1] - nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            res = Math.min(res, max - min);
        }

        return res;
    }
}
