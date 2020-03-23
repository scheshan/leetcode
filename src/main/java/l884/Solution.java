package l884;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> m1 = toMap(A);
        Map<String, Integer> m2 = toMap(B);

        List<String> list = new LinkedList<>();
        diff(m1, m2, list);
        diff(m2, m1, list);

        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) {
            res[i++] = str;
        }
        return res;
    }

    private Map<String, Integer> toMap(String str) {
        Map<String, Integer> map = new HashMap<>();

        String[] arr = str.split(" ");
        for (String s : arr) {
            map.compute(s, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return map;
    }

    private void diff(Map<String, Integer> left, Map<String, Integer> right, List<String> res) {
        for (Map.Entry<String, Integer> entry : left.entrySet()) {
            if (entry.getValue() == 1 && !right.containsKey(entry.getKey())) {
                res.add(entry.getKey());
            }
        }
    }
}
