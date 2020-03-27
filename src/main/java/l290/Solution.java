package l290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = arr[i];

            if (m1.containsKey(c) && !Objects.equals(s, m1.get(c))) {
                return false;
            }
            if (m2.containsKey(s) && !Objects.equals(c, m2.get(s))) {
                return false;
            }
            m1.put(c, s);
            m2.put(s, c);
        }

        return true;
    }
}
