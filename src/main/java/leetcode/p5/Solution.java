package leetcode.p5;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public String longestPalindrome(String s) {
        int begin = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int b1 = i;
            int e1 = i;
            while (b1 >= 0 && e1 < s.length() && s.charAt(b1) == s.charAt(e1)) {
                b1--;
                e1++;
            }
            b1++;
            e1--;
            if (e1 - b1 > end - begin) {
                begin = b1;
                end = e1;
            }

            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                b1 = i - 1;
                e1 = i;
                while (b1 >= 0 && e1 < s.length() && s.charAt(b1) == s.charAt(e1)) {
                    b1--;
                    e1++;
                }
                b1++;
                e1--;
                if (e1 - b1 > end - begin) {
                    begin = b1;
                    end = e1;
                }
            }
        }

        return s.substring(begin, end + 1);
    }
}
