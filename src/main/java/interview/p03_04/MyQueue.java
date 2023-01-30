package interview.p03_04;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class MyQueue {

    private Deque<Integer> d1;

    private Deque<Integer> d2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        d1 = new ArrayDeque<>();
        d2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        transfer();
        d2.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        transfer();
        return d1.removeLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        transfer();
        return d1.peekLast();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
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
