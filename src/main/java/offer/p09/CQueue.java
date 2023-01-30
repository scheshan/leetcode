package offer.p09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * CQueue
 *
 * @author heshan
 * @date 2023/1/30
 */
public class CQueue {

    private Deque<Integer> d1;

    private Deque<Integer> d2;

    public CQueue() {
        d1 = new ArrayDeque<>();
        d2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        transfer();
        d2.addLast(value);
    }

    public int deleteHead() {
        if (isEmpty()) {
            return -1;
        }
        transfer();
        return d1.removeLast();
    }

    private boolean isEmpty() {
        return d1.isEmpty() && d2.isEmpty();
    }

    private void transfer() {
        if (d1.isEmpty()) {
            while (!d2.isEmpty()) {
                d1.addLast(d2.removeLast());
            }
        }
    }
}
