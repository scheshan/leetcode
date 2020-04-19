package l7;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int n = x % 10;
            x /= 10;

            if (res > 0 && res > (Integer.MAX_VALUE - n) / 10) {
                return 0;
            } else if (res < 0 && res < (Integer.MIN_VALUE - n) / 10) {
                return 0;
            }

            res = 10 * res + n;
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().reverse(-2147483648);
        System.out.println(res);
    }
}
