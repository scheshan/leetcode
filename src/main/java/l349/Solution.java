package l349;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int num : nums1) {
            s1.add(num);
        }

        Set<Integer> s2 = new HashSet<>();
        for (int num : nums2) {
            if (s1.contains(num)) {
                s2.add(num);
            }
        }

        int[] result = new int[s2.size()];
        int i = 0;
        for (Integer n : s2) {
            result[i++] = n;
        }

        return result;
    }
}
