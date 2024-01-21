package leetcode.p7;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public int reverse(int x) {
        int res = 0;

        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = true;
        }

        while (x != 0) {
            int n = x % 10;
            x /= 10;

            if ((Integer.MAX_VALUE - n) / 10 < res) {
                return 0;
            }

            res = res * 10 + n;
        }

        return negative ? -res : res;
    }
}
