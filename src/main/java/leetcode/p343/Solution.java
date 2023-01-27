package leetcode.p343;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        int res = 0;
        for (int i = 1; i <= n >> 1; i++) {
            res = Math.max(res, count(i) * count(n - i));
        }
        return res;
    }

    private int count(int n) {
        if (n <= 4) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = n;
        for (int i = 1; i <= n >> 1; i++) {
            res = Math.max(res, count(i) * count(n - i));
        }
        map.put(n, res);
        return res;
    }
}
