package leetcode.p1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }

        StringBuilder sb = new StringBuilder();

        int ind = 0;
        while (ind < s.length()) {
            int pre = ind;
            while (ind < s.length() && s.charAt(ind) != '(') {
                ind++;
            }
            sb.append(s, pre, ind);

            ind++;
            pre = ind;
            while (ind < s.length() && s.charAt(ind) != ')') {
                ind++;
            }
            if (pre < s.length()) {
                String key = s.substring(pre, ind);
                sb.append(map.getOrDefault(key, "?"));
            }
            ind++;
        }

        return sb.toString();
    }
}
