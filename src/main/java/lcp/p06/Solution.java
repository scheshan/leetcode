package lcp.p06;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += coin / 2;
            res += coin & 1;
        }
        return res;
    }
}
