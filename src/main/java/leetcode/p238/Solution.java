package leetcode.p238;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length], post = new int[nums.length];
        pre[0] = 1;
        post[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[i];
        }

        return res;
    }
}
