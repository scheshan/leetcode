package leetcode.p2279;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] bags = new int[capacity.length];
        for (int i = 0; i < bags.length; i++) {
            bags[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(bags);

        int res = 0;
        for (int i = 0; i < bags.length && additionalRocks > 0; i++) {
            if (additionalRocks >= bags[i]) {
                res++;
            }
            additionalRocks -= bags[i];
        }
        return res;
    }
}
