package l205;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char left = s.charAt(i);
            char right = t.charAt(i);

            if (m1.containsKey(left) && m2.containsKey(right)) {
                if (left != m2.get(right) || right != m1.get(left)) {
                    return false;
                }
            } else if (m1.containsKey(left) || m2.containsKey(right)) {
                return false;
            } else {
                m1.put(left, right);
                m2.put(right, left);
            }
        }

        return true;
    }
}