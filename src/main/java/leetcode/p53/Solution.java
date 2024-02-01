package leetcode.p53;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int pre = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }

        return res;
    }
}
