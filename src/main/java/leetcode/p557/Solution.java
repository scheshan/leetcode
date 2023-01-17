package leetcode.p557;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder(s.length());

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (r < s.length() && s.charAt(r) == ' ') {
                res.append(' ');
                r++;
                l++;
            }
            while (r < s.length() && s.charAt(r) != ' ') {
                r++;
            }

            for (int i = r - 1; i >= l; i--) {
                res.append(s.charAt(i));
            }
            l = r;
        }
        return res.toString();
    }
}
