package leetcode.p7;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public int reverse(int x) {
        boolean negative = false;
        int res = 0;

        if (x < 0) {
            negative = true;
            x = -x;
        }

        while (x > 0) {
            if (res > 214748364) {
                return 0;
            }
            if (res == 214748364 && x % 10 > 7) {
                return 0;
            }

            res = res * 10 + x % 10;
            x /= 10;
        }
        if (negative) {
            res = -res;
        }

        return res;
    }
}
