package leetcode.p387;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
