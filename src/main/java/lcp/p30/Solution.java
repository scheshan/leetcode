package lcp.p30;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/6
 */
public class Solution {

    public int magicTower(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1, o2);
        });

        long total = 1, total2 = 0;
        int res = 0;

        for (int num : nums) {
            total += num;
            if (num < 0) {
                queue.add(num);
            }

            while (total <= 0 && !queue.isEmpty()) {
                int n = queue.remove();
                total -= n;
                total2 += n;
                res++;
            }
        }

        return total + total2 >= 1 ? res : -1;
    }
}
