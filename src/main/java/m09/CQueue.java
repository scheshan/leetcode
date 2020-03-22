package m09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * CQueue
 *
 * @author heshan
 * @date 2020/3/22
 */
public class CQueue {

    private Deque<Integer> d1 = new LinkedList<>();

    private Deque<Integer> d2 = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        d1.push(value);
    }

    public int deleteHead() {
        if (empty()) {
            return -1;
        }

        transfer();

        return d2.pop();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return d1.isEmpty() && d2.isEmpty();
    }

    private void transfer() {
        if (!d2.isEmpty()) {
            return;
        }

        while (!d1.isEmpty()) {
            d2.push(d1.pop());
        }
    }
}
