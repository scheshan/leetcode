package leetcode.p238;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = pre * nums[i];
            pre = res[i];
        }

        pre = 1;
        for (int i = 0; i < res.length; i++) {
            int after = 1;
            if (i < res.length - 1) {
                after = res[i + 1];
            }
            res[i] = pre * after;
            pre *= nums[i];
        }
        return res;
    }
}
