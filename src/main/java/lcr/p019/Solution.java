package lcr.p019;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    private boolean valid(String s, int l, int r, boolean replace) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else if (!replace) {
                return valid(s, l + 1, r, true) || valid(s, l, r - 1, true);
            } else {
                return false;
            }
        }

        return true;
    }
}
