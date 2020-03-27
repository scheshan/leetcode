package l594;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() - 1)) {
                res = Math.max(res, map.get(entry.getKey() - 1) + entry.getValue());
            }
        }

        return res;
    }
}
