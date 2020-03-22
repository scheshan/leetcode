package l1002;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = toMap(A[0]);

        for (int i = 1; i < A.length; i++) {
            map = combine(map, toMap(A[i]));
        }

        List<String> res = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.add(entry.getKey().toString());
            }
        }

        return res;
    }

    private Map<Character, Integer> combine(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        Map<Character, Integer> map = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (m2.containsKey(entry.getKey())) {
                map.put(entry.getKey(), Math.min(entry.getValue(), m2.get(entry.getKey())));
            }
        }

        return map;
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
