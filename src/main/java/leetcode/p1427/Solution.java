package leetcode.p1427;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/19
 */
public class Solution {

    public String stringShift(String s, int[][] shift) {
        int n = 0;
        for (int[] item : shift) {
            if (item[0] == 0) {
                n += item[1];
            } else {
                n -= item[1];
            }
        }

        n %= s.length();
        if (n < 0) {
            n = s.length() + n;
        }

        if (n == 0) {
            return s;
        }

        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
