package leetcode.p1796;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public int secondHighest(String s) {
        char c1 = '0' - 1;
        char c2 = '0' - 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (ch == c1 || ch == c2) {
                    continue;
                }

                if (ch > c2) {
                    c2 = ch;
                }
                if (ch > c1) {
                    c2 = c1;
                    c1 = ch;
                }
            }
        }

        return c2 == '0' - 1 ? -1 : c2 - '0';
    }
}
