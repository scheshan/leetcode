package leetcode.p125;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!isValid(s.charAt(l))) {
                l++;
            } else if (!isValid(s.charAt(r))) {
                r--;
            } else if (!isSame(s.charAt(l++), s.charAt(r--))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private boolean isSame(char a, char b) {
        if (a == b) {
            return true;
        }

        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
