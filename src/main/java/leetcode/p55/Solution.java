package leetcode.p55;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length && max >= i; i++) {
            if (max >= nums.length) {
                return true;
            }

            max = Math.max(max, nums[i] + i);
        }

        return max >= nums.length - 1;
    }
}
