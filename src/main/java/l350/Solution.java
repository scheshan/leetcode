package l350;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap();
        for (int num : nums1) {
            m1.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (m1.containsKey(num)) {
                int value = m1.get(num);
                value--;
                if (value == 0) {
                    m1.remove(num);
                } else {
                    m1.put(num, value);
                }
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
