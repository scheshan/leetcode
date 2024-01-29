package leetcode.p2974;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int d = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = d;
        }
        return nums;
    }
}
