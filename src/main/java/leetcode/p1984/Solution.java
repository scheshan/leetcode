package leetcode.p1984;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
