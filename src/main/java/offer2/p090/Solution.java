package offer2.p090;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int l, int r) {
        int[] state = new int[2];

        for (int i = l; i <= r; i++) {
            int s0 = state[1] + nums[i];
            int s1 = state[0];

            state[0] = Math.max(state[0], s0);
            state[1] = Math.max(state[1], s1);
        }

        return Math.max(state[0], state[1]);
    }
}
