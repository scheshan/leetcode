package leetcode.p287;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            if (num < 0) {
                num = -num;
            }

            if (nums[num] < 0) {
                return num;
            }
            nums[num] *= -1;
        }

        return 0;
    }
}
