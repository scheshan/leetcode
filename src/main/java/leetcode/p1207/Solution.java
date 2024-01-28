package leetcode.p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
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

        Set<Integer> exist = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (exist.contains(entry.getValue())) {
                return false;
            }
            exist.add(entry.getValue());
        }
        return true;
    }
}
