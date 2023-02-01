package offer.p49;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>(Long::compare);
        queue.add(1L);
        Set<Long> visit = new HashSet<>();

        int res = 0;
        for (int i = 0; i < n; i++) {
            long num = queue.remove();
            res = (int) num;

            addQueue(queue, visit, num * 2);
            addQueue(queue, visit, num * 3);
            addQueue(queue, visit, num * 5);
        }
        return res;
    }

    private void addQueue(Queue<Long> queue, Set<Long> visit, long num) {
        if (visit.contains(num)) {
            return;
        }
        if (num < 0 || num > Integer.MAX_VALUE) {
            return;
        }
        visit.add(num);
        queue.add(num);
    }
}
