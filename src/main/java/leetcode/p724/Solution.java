package leetcode.p724;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur << 1 == total - nums[i]) {
                return i;
            }
            cur += nums[i];
        }

        return -1;
    }
}
