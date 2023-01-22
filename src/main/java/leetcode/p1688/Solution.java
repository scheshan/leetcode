package leetcode.p1688;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int numberOfMatches(int n) {
        int res = 0;

        while (n > 1) {
            if ((n & 1) == 1) {
                res += (n - 1) >> 1;
                n = ((n - 1) >> 1) + 1;
            } else {
                res += n >> 1;
                n >>= 1;
            }
        }
        return res;
    }
}
