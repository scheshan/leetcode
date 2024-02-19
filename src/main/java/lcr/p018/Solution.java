package lcr.p018;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !isValid(s.charAt(l))) {
                l++;
            }
            while (l < r && !isValid(s.charAt(r))) {
                r--;
            }

            char c1 = Character.toLowerCase(s.charAt(l++));
            char c2 = Character.toLowerCase(s.charAt(r--));

            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }

        return false;
    }
}
