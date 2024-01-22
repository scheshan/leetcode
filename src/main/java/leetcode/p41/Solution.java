package leetcode.p41;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/22
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int d = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = d;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
