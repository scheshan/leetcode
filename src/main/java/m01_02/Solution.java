package m01_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> m1 = toMap(s1);
        Map<Character, Integer> m2 = toMap(s2);

        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (!m2.containsKey(entry.getKey()) || m2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return map;
    }
}
