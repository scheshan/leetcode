package leetcode.p2229;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public boolean isConsecutive(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        Arrays.sort(nums);
        if (nums.length == 2) {
            return nums[1] - nums[0] == 1;
        }
        int delta = nums[1] - nums[0];
        if (delta == 0) {
            return false;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != delta) {
                return false;
            }
        }
        return true;
    }
}
