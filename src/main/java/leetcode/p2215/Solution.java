package leetcode.p2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
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

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        for (int num : s1) {
            if (!s2.contains(num)) {
                l1.add(num);
            }
        }
        res.add(l1);

        List<Integer> l2 = new ArrayList<>();
        for (int num : s2) {
            if (!s1.contains(num)) {
                l2.add(num);
            }
        }
        res.add(l2);

        return res;
    }
}
