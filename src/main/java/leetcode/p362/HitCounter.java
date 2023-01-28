package leetcode.p362;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class HitCounter {

    private Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        removeTimeout(timestamp);
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        removeTimeout(timestamp);
        return queue.size();
    }

    private void removeTimeout(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.remove();
        }
    }
}
