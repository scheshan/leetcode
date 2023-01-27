package offer2.p089;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int rob(int[] nums) {
        int[] state = new int[2];
        for (int num : nums) {
            int s0 = state[1] + num;
            int s1 = state[0];

            state[0] = Math.max(state[0], s0);
            state[1] = Math.max(state[1], s1);
        }

        return Math.max(state[0], state[1]);
    }
}
