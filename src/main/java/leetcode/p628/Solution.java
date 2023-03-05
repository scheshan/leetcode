package leetcode.p628;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int res = Integer.MIN_VALUE;

        res = Math.max(res, nums[0] * nums[1] * nums[2]);
        res = Math.max(res, nums[0] * nums[1] * nums[nums.length - 1]);
        res = Math.max(res, nums[0] * nums[nums.length - 2] * nums[nums.length - 1]);
        res = Math.max(res, nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);

        return res;
    }
}
