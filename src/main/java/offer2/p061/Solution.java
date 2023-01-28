package offer2.p061;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return o2[2] - o1[2];
        });
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int n = n1 + n2;
                if (queue.size() < k) {
                    queue.add(new int[]{n1, n2, n});
                } else {
                    if (queue.peek()[2] > n) {
                        queue.remove();
                        queue.add(new int[]{n1, n2, n});
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            int[] arr = queue.remove();
            res.add(Arrays.asList(arr[0], arr[1]));
        }

        return res;
    }
}
