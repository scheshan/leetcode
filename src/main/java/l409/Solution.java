package l409;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int longestPalindrome(String s) {
        int result = 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                set.remove(ch);
                result += 2;
            } else {
                set.add(ch);
            }
        }

        return set.isEmpty() ? result : result + 1;
    }
}
