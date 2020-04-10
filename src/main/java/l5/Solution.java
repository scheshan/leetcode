package l5;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }

        Range res = new Range(0, 0);
        for (int i = 0; i < s.length(); i++) {
            res = max(res, count(s, i, i));
            if (i < s.length() - 1) {
                res = max(res, count(s, i, i + 1));
            }
        }

        return new String(s.toCharArray(), res.left, res.right - res.left + 1);
    }

    private Range count(String s, int left, int right) {
        Range res = new Range(left, left);

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res.left = left;
            res.right = right;

            left--;
            right++;
        }

        return res;
    }

    private Range max(Range x, Range y) {
        if (y.right - y.left > x.right - x.left) {
            return y;
        }
        return x;
    }

    private class Range {

        int left;

        int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ccc"));
    }
}
