package leetcode.p1394;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        int res = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == entry.getKey()) {
                res = Math.max(res, entry.getKey());
            }
        }
        return res;
    }
}
