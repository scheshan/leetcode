package leetcode.p724;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((pre << 1) + nums[i] == total) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }
}
