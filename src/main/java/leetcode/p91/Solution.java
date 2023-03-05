package leetcode.p91;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int numDecodings(String s) {
        int n1 = 1;
        int n2 = 1;

        for (int i = 0; i < s.length(); i++) {
            int n = 0;
            if (s.charAt(i) != '0') {
                n += n2;
            }
            if (i > 0 && (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26 && s.charAt(i - 1) != '0') {
                n += n1;
            }
            n1 = n2;
            n2 = n;
        }

        return n2;
    }
}
