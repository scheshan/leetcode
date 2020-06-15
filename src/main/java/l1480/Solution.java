package l1480;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/15
 */
public class Solution {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
