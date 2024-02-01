package leetcode.p287;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int ind = Math.abs(num) - 1;

            if (nums[ind] < 0) {
                return Math.abs(num);
            }
            nums[ind] = -nums[ind];
        }

        return -1;
    }
}
