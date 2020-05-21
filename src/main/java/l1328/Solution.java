package l1328;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/21
 */
public class Solution {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();

        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            if (chars[l] != 'a') {
                chars[l] = 'a';
                return new String(chars);
            }
            l++;
            r--;
        }
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }
}
