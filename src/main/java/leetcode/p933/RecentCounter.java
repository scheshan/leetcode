package leetcode.p933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class RecentCounter {

    Queue<Integer> queue;

    int total;

    public RecentCounter() {
        queue = new LinkedList<>();
        total = 0;
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            total -= queue.remove();
        }
        queue.add(t);
        return queue.size();
    }
}
