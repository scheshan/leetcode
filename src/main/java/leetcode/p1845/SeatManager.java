package leetcode.p1845;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * SeatManager
 *
 * @author heshan
 * @date 2023/2/1
 */
public class SeatManager {

    private Queue<Integer> queue;

    private int max;

    private int cur;

    public SeatManager(int n) {
        queue = new PriorityQueue<>(Integer::compareTo);
        max = n;
    }

    public int reserve() {
        if (!queue.isEmpty()) {
            return queue.remove();
        }

        return ++cur;
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
