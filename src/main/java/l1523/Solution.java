package l1523;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/8/2
 */
public class Solution {

    public int countOdds(int low, int high) {
        int n = high - low + 1;

        int res = n >> 1;

        if ((n & 1) == 1 && (low & 1) == 1) {
            res++;
        }

        return res;
    }
}
