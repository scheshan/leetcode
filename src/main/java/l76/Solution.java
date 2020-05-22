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
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            compute(tCount, t.charAt(i), 1);
        }

        int distance = tCount.size();
        int minSize = Integer.MAX_VALUE;
        int resLeft = 0;
        int resRight = s.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (tCount.containsKey(s.charAt(right))) {
                if (compute(sCount, s.charAt(right), 1) == tCount.get(s.charAt(right))) {
                    distance--;
                }
            }

            while (distance == 0) {
                if (right - left < minSize) {
                    resLeft = left;
                    resRight = right;
                    minSize = right - left;
                }
                if (tCount.containsKey(s.charAt(left))) {
                    if (compute(sCount, s.charAt(left), -1) < tCount.get(s.charAt(left))) {
                        distance++;
                    }
                }
                left++;
            }
            right++;
        }

        if (minSize > s.length()) {
            return "";
        }

        return s.substring(resLeft, resRight + 1);
    }

    private int compute(Map<Character, Integer> map, char key, int delta) {
        return map.compute(key, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            v += delta;
            return v;
        });
    }

    public static void main(String[] args) {
        new Solution().minWindow("aab", "aab");
    }
}
