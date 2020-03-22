package l187;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>();

        int l = 0;
        int r = 10;

        while (r <= s.length()) {
            String seq = s.substring(l, r);
            if (!map.containsKey(seq)) {
                map.put(seq, 1);
            } else {
                int count = map.compute(seq, (k, v) -> {
                    return ++v;
                });
                if (count == 2) {
                    res.add(seq);
                }
            }

            l++;
            r++;
        }

        return res;
    }
}
