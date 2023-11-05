package leetcode.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        while (r < s.length()) {
            char ch = s.charAt(r++);
            map.compute(ch, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });

            while (map.size() < r - l) {
                ch = s.charAt(l++);
                int c = map.get(ch);
                if (c == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, c - 1);
                }
            }

            res = Math.max(res, r - l);
        }

        return res;
    }
}
