package leetcode.p8;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int myAtoi(String s) {
        int res = 0;
        boolean positive = true;

        int ind = 0;
        while (ind < s.length() && s.charAt(ind) == ' ') {
            ind++;
        }

        if (ind < s.length() && (s.charAt(ind) == '+' || s.charAt(ind) == '-')) {
            positive = s.charAt(ind) == '+';
            ind++;
        }

        while (ind < s.length() && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
            int t = s.charAt(ind) - '0';
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

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
