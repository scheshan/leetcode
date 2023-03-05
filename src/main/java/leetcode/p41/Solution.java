package leetcode.p41;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int num : nums) {
            if (num < 0) {
                num = -num;
            }
            if (num - 1 < nums.length && nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
