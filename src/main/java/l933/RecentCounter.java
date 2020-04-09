package l933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * RecentCounter
 *
 * @author heshan
 * @date 2020/4/9
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.remove();
        }

        queue.add(t);
        return queue.size();
    }
}
