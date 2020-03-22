package l76;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.compute(t.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        String res = "";

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (tmap.containsKey(ch)) {
                map.compute(ch, (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }

            while (mapEq(map, tmap)) {
                if (res.equals("") || right - left + 1 < res.length()) {
                    res = s.substring(left, right + 1);
                }

                if (tmap.containsKey(s.charAt(left))) {
                    int count = map.compute(s.charAt(left), (k, v) -> {
                        return --v;
                    });
                    if (count == 0) {
                        map.remove(s.charAt(left));
                    }
                }
                left++;
            }

            right++;
        }

        return res;
    }

    private boolean mapEq(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (!m2.containsKey(entry.getKey())) {
                return false;
            }
            if (entry.getValue().compareTo(m2.get(entry.getKey())) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC", "ABC");
    }
}
