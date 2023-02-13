package leetcode.p1124;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int longestWPI(int[] hours) {
        int res = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < hours.length; i++) {
            pre += hours[i] > 8 ? 1 : -1;
            if (pre > 0) {
                res = Math.max(res, i + 1);
            }
            if (map.containsKey(pre - 1)) {
                res = Math.max(i - map.get(pre - 1), res);
            }
            if (!map.containsKey(pre)) {
                map.put(pre, i);
            }
        }
        return res;
    }
}
