package leetcode.p811;

import java.util.ArrayList;
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

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            count(str, map);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(String.format("%s %s", entry.getValue(), entry.getKey()));
        }
        return res;
    }

    private void count(String str, Map<String, Integer> map) {
        int cnt = 0;
        int ind = 0;
        while (ind < str.length() && str.charAt(ind) != ' ') {
            cnt = cnt * 10 + str.charAt(ind) - '0';
            ind++;
        }
        ind++;

        while (ind < str.length()) {
            String domain = str.substring(ind);
            map.put(domain, map.getOrDefault(domain, 0) + cnt);
            while (ind < str.length() && str.charAt(ind) != '.') {
                ind++;
            }
            ind++;
        }
    }
}
