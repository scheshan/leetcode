package leetcode.p349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();

        List<Integer> res = new ArrayList<>();

        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
            if (s1.contains(num)) {
                s1.remove(num);
                res.add(num);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
