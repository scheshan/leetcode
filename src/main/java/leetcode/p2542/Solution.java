package leetcode.p2542;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res = 0, sum = 0;

        Integer[] idx = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> {
            return Integer.compare(nums2[o2], nums2[o1]);
        });

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            sum += nums1[idx[i]];
            queue.add(nums1[idx[i]]);
        }

        for (int i = k - 1; i < idx.length; i++) {
            sum += nums1[idx[i]];
            queue.add(nums1[idx[i]]);

            res = Math.max(res, sum * nums2[idx[i]]);

            sum -= queue.remove();
        }

        return res;
    }
}
