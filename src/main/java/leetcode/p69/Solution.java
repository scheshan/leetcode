package leetcode.p69;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int mySqrt(int x) {
        int res = 0;

        int l = 1, r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int num = x / mid;

            if (num == mid) {
                return mid;
            } else if (num > mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
