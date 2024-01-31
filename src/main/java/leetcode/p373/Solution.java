package leetcode.p373;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/31
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(nums1[o1[0]] + nums2[o1[1]], nums1[o2[0]] + nums2[o2[1]]);
        });

        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>(k);
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int[] arr = queue.remove();
            res.add(Arrays.asList(nums1[arr[0]], nums2[arr[1]]));

            if (arr[1] < nums2.length - 1) {
                arr[1]++;
                queue.add(arr);
            }
        }

        return res;
    }
}
