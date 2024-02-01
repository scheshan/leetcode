package leetcode.p5;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    private int max = 0;
    private int l;
    private int r;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }

        return s.substring(l, r + 1);
    }

    private void find(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    this.l = l;
                    this.r = r;
                }

                l--;
                r++;
            } else {
                break;
            }
        }
    }
}
