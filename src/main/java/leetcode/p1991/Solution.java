package leetcode.p1991;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int findMiddleIndex(int[] nums) {
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
