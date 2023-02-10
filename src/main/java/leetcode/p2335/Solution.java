package leetcode.p2335;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/11
 */
public class Solution {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);

        if (amount[2] > amount[0] + amount[1]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) >> 1;
    }
}
