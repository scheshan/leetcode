package offer.p15;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}
