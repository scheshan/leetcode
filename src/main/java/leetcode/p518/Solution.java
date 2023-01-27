package leetcode.p518;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int change(int amount, int[] coins) {
        int[] state = new int[amount + 1];
        state[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                state[i] += state[i - coin];
            }
        }

        return state[amount];
    }
}
