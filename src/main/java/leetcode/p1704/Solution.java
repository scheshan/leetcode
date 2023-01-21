package leetcode.p1704;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public boolean halvesAreAlike(String s) {
        int x = 0, y = 0;
        int slow = 0;
        int fast = s.length() >> 1;
        while (fast < s.length()) {
            if (isVowel(s.charAt(slow++))) {
                x++;
            }
            if (isVowel(s.charAt(fast++))) {
                y++;
            }
        }
        return x == y;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
