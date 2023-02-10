package leetcode.p290;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        int ind = 0;
        int r = 0;
        while (r < s.length() && ind < pattern.length()) {
            int pre = r;
            while (r < s.length() && s.charAt(r) != ' ') {
                r++;
            }

            char ch = pattern.charAt(ind);
            String str = s.substring(pre, r);

            if (m1.containsKey(ch) && !m1.get(ch).equals(str)) {
                return false;
            }
            if (m2.containsKey(str) && m2.get(str) != ch) {
                return false;
            }
            m1.put(ch, str);
            m2.put(str, ch);

            if (r < s.length()) {
                r++;
            }
            ind++;
        }

        return ind == pattern.length() && r == s.length();
    }
}
