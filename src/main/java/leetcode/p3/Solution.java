package leetcode.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            map.compute(s.charAt(r++), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });

            while (map.size() < r - l) {
                char ch = s.charAt(l++);
                int count = map.get(ch);
                if (count == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, count - 1);
                }
            }

            res = Math.max(res, r - l);
        }

        return res;
    }
}
