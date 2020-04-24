package l1086;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int[][] highFive(int[][] items) {
        PriorityQueue<Integer>[] queues = new PriorityQueue[1000];
        int count = 0;
        for (int[] item : items) {
            if (queues[item[0]] == null) {
                count++;
                queues[item[0]] = new PriorityQueue<>();
            }
            Queue<Integer> queue = queues[item[0]];
            if (queue.size() < 5) {
                queue.add(item[1]);
            } else if (queue.peek() < item[1]) {
                queue.remove();
                queue.add(item[1]);
            }
        }

        int[][] res = new int[count][2];
        int ind = 0;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i] == null) {
                continue;
            }

            int total = 0;
            Queue<Integer> queue = queues[i];
            while (!queue.isEmpty()) {
                total += queue.remove();
            }
            res[ind++] = new int[]{i, total / 5};
        }
        return res;
    }
}
