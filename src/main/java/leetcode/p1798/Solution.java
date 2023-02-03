package leetcode.p1798;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int num = 0;
        for (int i = 0; i < coins.length; i++) {
            if (num >= coins[i] - 1) {
                num += coins[i];
            } else {
                break;
            }
        }

        return num + 1;
    }
}
