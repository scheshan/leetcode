package leetcode.p1480;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
