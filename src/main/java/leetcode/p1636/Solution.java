package leetcode.p1636;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((o1, o2) -> {
            int n = Integer.compare(o1.getValue(), o2.getValue());
            if (n != 0) {
                return n;
            }
            return Integer.compare(o2.getKey(), o1.getKey());
        });

        int[] res = new int[nums.length];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                res[ind++] = entry.getKey();
            }
        }
        return res;
    }
}
