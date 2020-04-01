package l1023;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>(queries.length);

        for (String query : queries) {
            res.add(match(query, pattern));
        }

        return res;
    }

    private boolean match(String query, String pattern) {
        int l = 0;
        int r = 0;

        while (l < query.length() && r < pattern.length()) {
            char c1 = query.charAt(l);
            if (c1 >= 'A' && c1 <= 'Z') {
                if (c1 != pattern.charAt(r)) {
                    return false;
                }
                r++;
            } else {
                if (c1 == pattern.charAt(r)) {
                    r++;
                }
            }
            l++;
        }

        if (r < pattern.length()) {
            return false;
        }
        while (l < query.length()) {
            if (query.charAt(l) >= 'A' && query.charAt(l) <= 'Z') {
                return false;
            }
            l++;
        }

        return true;
    }
}
