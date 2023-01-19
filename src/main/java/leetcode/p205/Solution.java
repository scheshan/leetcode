package leetcode.p205;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> from = new HashMap<>();
        Map<Character, Character> to = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (from.containsKey(ch1)) {
                if (from.get(ch1) != ch2) {
                    return false;
                }
                continue;
            }
            if (to.containsKey(ch2)) {
                return false;
            }

            from.put(ch1, ch2);
            to.put(ch2, ch1);
        }

        return true;
    }
}
