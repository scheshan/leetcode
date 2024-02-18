package leetcode.p7;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int reverse(int x) {
        long res = 0, sign = 1;

        if (x < 0) {
            sign = -1;
            x = -x;
        }

        while (x > 0) {
            int n = x % 10;
            x /= 10;

            res = res * 10 + n;
            if (res < 0) {
                return 0;
            }
        }

        res = sign * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
