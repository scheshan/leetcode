package leetcode.p1877;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;

        int res = 0;

        while (l < r) {
            res = Math.max(res, nums[l++] + nums[r--]);
        }
        return res;
    }
}
