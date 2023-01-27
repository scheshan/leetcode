package offer2.p072;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int mySqrt(int x) {
        int res = 0;

        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long num = (long) mid * mid;
            if (num == x) {
                res = mid;
                break;
            } else if (num > x || num < 0) {
                r = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}
