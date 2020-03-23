package l811;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : cpdomains) {
            String[] arr = str.split(" ");
            int count = Integer.parseInt(arr[0]);
            String domain = arr[1];

            count(map, domain, count);
            for (int i = domain.length() - 1; i >= 0; i--) {
                if (domain.charAt(i) == '.') {
                    count(map, domain.substring(i + 1), count);
                }
            }
        }

        List<String> res = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue().toString() + " " + entry.getKey());
        }

        return res;
    }

    private void count(Map<String, Integer> map, String domain, int count) {
        map.compute(domain, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return v + count;
        });
    }
}
