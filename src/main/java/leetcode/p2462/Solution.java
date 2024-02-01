package leetcode.p2462;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int d = Integer.compare(costs[o1], costs[o2]);
            if (d == 0) {
                d = Integer.compare(o1, o2);
            }
            return d;
        });

        int l = 0, r = costs.length - 1;
        while (l < candidates) {
            queue.add(l++);
        }
        for (int i = 0; i < candidates && l <= r; i++) {
            queue.add(r--);
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            int ind = queue.remove();

            res += costs[ind];

            if (ind < l && l <= r) {
                queue.add(l++);
            }
            if (ind > r && l <= r) {
                queue.add(r--);
            }
        }

        return res;
    }
}
