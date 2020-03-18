package l125;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            if (!isLetter(l)) {
                left++;
                continue;
            }

            char r = s.charAt(right);
            if (!isLetter(r)) {
                right--;
                continue;
            }

            if (!match(l, r)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private boolean match(char a, char b) {
        return a == b || Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("0P");
    }
}
