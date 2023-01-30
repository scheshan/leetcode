package leetcode.p2042;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean areNumbersAscending(String s) {
        int pre = 0;

        int ind = 0;
        while (ind < s.length()) {
            while (ind < s.length() && (s.charAt(ind) < '0' || s.charAt(ind) > '9')) {
                ind++;
            }

            int cur = 0;
            while (ind < s.length() && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
                cur = cur * 10 + s.charAt(ind) - '0';
                ind++;
            }

            if (cur > 0 && cur <= pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
