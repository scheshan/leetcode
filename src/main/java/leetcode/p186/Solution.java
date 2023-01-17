package leetcode.p186;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int l = 0;
        int r = 0;
        while (r < s.length) {
            while (r < s.length && s[r] == ' ') {
                r++;
                l++;
            }
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            l = r;
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
