package offer2.p016;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (left < map.get(s.charAt(i)) + 1) {
                    left = map.get(s.charAt(i)) + 1;
                }
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i);
        }

        return res;
    }
}
