package l647;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += count(s, i, i);

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                res += count(s, i, i + 1);
            }
        }

        return res;
    }

    private int count(String s, int left, int right) {
        int l = left;
        int r = left;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            l = left;
            r = right;

            left--;
            right++;
        }

        return (r - l + 2) / 2;
    }
}
