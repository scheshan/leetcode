package leetcode.p884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> c1 = count(s1);
        Map<String, Integer> c2 = count(s2);

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : c1.entrySet()) {
            if (entry.getValue() == 1 && !c2.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : c2.entrySet()) {
            if (entry.getValue() == 1 && !c1.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private Map<String, Integer> count(String word) {
        Map<String, Integer> res = new HashMap<>();

        int l = 0;
        int r = 0;
        while (r < word.length()) {
            while (r < word.length() && word.charAt(r) != ' ') {
                r++;
            }

            if (r <= word.length()) {
                res.compute(word.substring(l, r), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
            r++;
            l = r;
        }
        return res;
    }
}
