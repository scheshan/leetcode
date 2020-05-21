package l5;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    int left = 0;

    int right = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            if (i < s.length() - 1) {
                count(s, i, i + 1);
            }
        }

        return new String(s.toCharArray(), left, right - left + 1);
    }

    private void count(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        l = l + 1;
        r = r - 1;
        if (r - l > right - left) {
            right = r;
            left = l;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
    }
}
