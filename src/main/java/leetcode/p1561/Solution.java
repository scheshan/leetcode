package leetcode.p1561;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int res = 0;
        int n = piles.length / 3;
        while (n < piles.length) {
            res += piles[n];
            n += 2;
        }
        return res;
    }
}
