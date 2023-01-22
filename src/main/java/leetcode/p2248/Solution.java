package leetcode.p2248;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] arr : nums) {
            for (int num : arr) {
                count.compute(num, (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == nums.length) {
                res.add(entry.getKey());
            }
        }
        res.sort(Integer::compareTo);
        return res;
    }
}
