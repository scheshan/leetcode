package interview.p67;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int strToInt(String str) {
        int res = 0;
        boolean positive = true;

        int ind = 0;
        while (ind < str.length() && str.charAt(ind) == ' ') {
            ind++;
        }

        if (ind < str.length() && (str.charAt(ind) == '+' || str.charAt(ind) == '-')) {
            positive = str.charAt(ind) == '+';
            ind++;
        }

        while (ind < str.length() && str.charAt(ind) >= '0' && str.charAt(ind) <= '9') {
            int t = str.charAt(ind) - '0';
            if (positive && (res > Integer.MAX_VALUE / 10 || res * 10 > Integer.MAX_VALUE - t)) {
                res = Integer.MAX_VALUE;
                break;
            }
            if (!positive && (-res < Integer.MIN_VALUE / 10 || -res * 10 < Integer.MIN_VALUE + t)) {
                res = Integer.MIN_VALUE;
                break;
            }
            res = res * 10 + t;
            ind++;
        }
        return positive ? res : -res;
    }
}
