package leetcode.p933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * RecentCounter
 *
 * @author heshan
 * @date 2024/1/28
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.remove();
        }

        return queue.size();
    }
}
