package l1704;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/10
 */
public class Solution {

    public boolean halvesAreAlike(String s) {
        int left = 0;
        for (int i = 0; i < s.length() >> 1; i++) {
            if (match(s.charAt(i))) {
                left++;
            }
        }
        for (int i = (s.length() >> 1); i < s.length(); i++) {
            if (match(s.charAt(i))) {
                left--;
            }
        }
        return left == 0;
    }

    private boolean match(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
