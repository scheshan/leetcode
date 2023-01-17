package leetcode.p2531;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public char repeatedCharacter(String s) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (arr[ch - 'a']) {
                return ch;
            }
            arr[ch - 'a'] = true;
        }

        return ' ';
    }
}
