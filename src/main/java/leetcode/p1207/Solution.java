package leetcode.p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        Set<Integer> visit = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (visit.contains(entry.getValue())) {
                return false;
            }
            visit.add(entry.getValue());
        }
        return true;
    }
}
