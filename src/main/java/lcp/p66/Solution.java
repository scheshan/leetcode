package lcp.p66;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int minNumBooths(String[] demand) {
        Map<Character, Integer> res = new HashMap<>();

        for (String str : demand) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.compute(ch, (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!res.containsKey(entry.getKey())) {
                    res.put(entry.getKey(), entry.getValue());
                } else {
                    res.put(entry.getKey(), Math.max(res.get(entry.getKey()), entry.getValue()));
                }
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : res.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }
}
