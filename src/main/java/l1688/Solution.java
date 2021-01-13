package l1688;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/10
 */
public class Solution {

    public int numberOfMatches(int n) {
        int res = 0;

        while (n > 1) {
            res += n >> 1;
            if ((n & 1) == 1) {
                n = (n >> 1) + 1;
            } else {
                n = n >> 1;
            }
        }
        return res++;
    }
}
