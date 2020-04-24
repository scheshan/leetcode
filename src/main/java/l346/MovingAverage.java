package l346;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class MovingAverage {

    private int size;

    private Queue<Integer> queue;

    private int total;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() >= size) {
            total -= queue.remove();
        }
        queue.add(val);
        total += val;

        return total * 1.0 / queue.size();
    }
}
