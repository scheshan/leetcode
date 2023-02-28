package leetcode.p2574;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            total -= n;
            nums[i] = Math.abs(total - pre);
            pre += n;
        }
        return nums;
    }
}
