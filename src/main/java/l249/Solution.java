package l249;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/28
 */
public class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                int delta = str.charAt(i) - str.charAt(i - 1);
                if (delta < 0) {
                    delta += 26;
                }
                sb.append(delta);
            }

            map.compute(sb.toString(), (k, v) -> {
                if (v == null) {
                    v = new LinkedList<>();
                }
                v.add(str);
                return v;
            });
        }

        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
