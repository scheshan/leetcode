package lcp.p06;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/2
 */
public class Solution {

    public int minCount(int[] coins) {
        int res = 0;

        for (int coin : coins) {
            res += (coin + 1) >> 1;
        }

        return res;
    }
}
