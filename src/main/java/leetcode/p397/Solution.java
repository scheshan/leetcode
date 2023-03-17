package leetcode.p397;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public int integerReplacement(int n) {
        return count(n, new HashMap<>());
    }

    private int count(int n, Map<Integer, Integer> map) {
        if (n == 1) {
            return 0;
        }
        int res;
        if (map.containsKey(n)) {
            res = map.get(n);
        } else {
            if ((n & 1) == 0) {
                res = count(n >> 1, map) + 1;
            } else {
                res = Math.min(count(n >> 1, map), count((n >> 1) + 1, map)) + 2;
            }
            map.put(n, res);
        }
        return res;
    }
}
