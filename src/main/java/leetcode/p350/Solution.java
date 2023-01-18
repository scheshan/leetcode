package leetcode.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.containsKey(num)) {
                if (countMap.put(num, countMap.get(num) - 1) == 1) {
                    countMap.remove(num);
                }
                list.add(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
