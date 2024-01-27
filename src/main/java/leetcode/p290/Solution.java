package leetcode.p290;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ", -1);
        if (arr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!match(m1, pattern.charAt(i), m2, arr[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean match(Map<Character, String> m1, char ch, Map<String, Character> m2, String str) {
        if (m1.containsKey(ch) && m2.containsKey(str)) {
            return m1.get(ch).equals(str) && m2.get(str).equals(ch);
        } else if (!m1.containsKey(ch) && !m2.containsKey(str)) {
            m1.put(ch, str);
            m2.put(str, ch);
            return true;
        } else {
            return false;
        }
    }
}
