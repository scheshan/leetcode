package leetcode.p2150;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1 && !count.containsKey(entry.getKey() - 1) && !count.containsKey(entry.getKey() + 1)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
