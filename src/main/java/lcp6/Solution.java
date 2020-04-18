package lcp6;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += coin / 2;
            if ((coin & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}
