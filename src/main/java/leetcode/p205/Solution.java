package leetcode.p205;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!match(m1, m2, s.charAt(i), t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean match(Map<Character, Character> m1, Map<Character, Character> m2, char c1, char c2) {
        if (!m1.containsKey(c1) && !m2.containsKey(c2)) {
            m1.put(c1, c2);
            m2.put(c2, c1);
            return true;
        } else if (m1.containsKey(c1) && m2.containsKey(c2)) {
            return m1.get(c1).equals(c2) && m2.get(c2).equals(c1);
        }
        return false;
    }
}
