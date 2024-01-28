package leetcode.p2215;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
            s2.add(num);
        }

        List<Integer> l1 = new ArrayList<>();
        for (int num : nums1) {
            if (!s2.contains(num)) {
                l1.add(num);
                s2.add(num);
            }
        }

        List<Integer> l2 = new ArrayList<>();
        for (int num : nums2) {
            if (!s1.contains(num)) {
                l2.add(num);
                s1.add(num);
            }
        }

        return Arrays.asList(l1, l2);
    }
}
