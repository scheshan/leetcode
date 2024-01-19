package leetcode.p2974;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/19
 */
public class Solution {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int n = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = n;
        }

        return nums;
    }
}
