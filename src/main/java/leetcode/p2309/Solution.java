package leetcode.p2309;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public String greatestLetter(String s) {
        int n1 = 0, n2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                n1 |= 1 << (ch - 'a');
            } else {
                n2 |= 1 << (ch - 'A');
            }
        }

        for (int i = 25; i >= 0; i--) {
            int n = 1 << i;
            if ((n1 & n) != 0 && (n2 & n) != 0) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
