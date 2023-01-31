package leetcode.p896;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public boolean isMonotonic(int[] nums) {
        int dir = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (dir > 0) {
                    return false;
                }
                dir = -1;
            } else if (nums[i] > nums[i - 1]) {
                if (dir < 0) {
                    return false;
                }
                dir = 1;
            }
        }
        return true;
    }
}
