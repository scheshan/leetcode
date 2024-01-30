package leetcode.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            char ch = s.charAt(r++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() < r - l) {
                ch = s.charAt(l++);
                int v = map.get(ch);
                if (v == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, v - 1);
                }
            }

            res = Math.max(res, r - l);
        }

        return res;
    }
}
