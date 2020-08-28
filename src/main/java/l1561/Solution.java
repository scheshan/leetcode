package l1561;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/8/28
 */
public class Solution {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int res = 0;
        int ind = piles.length - 2;

        for (int i = 0; i < piles.length / 3; i++) {
            res += piles[ind];
            ind -= 2;
        }

        return res;
    }
}
