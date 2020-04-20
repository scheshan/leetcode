package l438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() == 0) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.compute(p.charAt(i), this::compute);
        }

        Map<Character, Integer> found = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                found.clear();
                right++;
                left = right;
                continue;
            }

            found.compute(ch, this::compute);
            while (found.get(ch) > map.get(ch)) {
                char l = s.charAt(left);
                found.compute(l, (k, v) -> --v);
                left++;
            }

            if (right - left + 1 == p.length()) {
                res.add(left);
            }
            right++;
        }
        return res;
    }

    private Integer compute(Character key, Integer value) {
        if (value == null) {
            value = 0;
        }
        return ++value;
    }
}
