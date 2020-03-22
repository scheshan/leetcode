package l232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * MyQueue
 *
 * @author heshan
 * @date 2020/3/22
 */
public class MyQueue {

    private Deque<Integer> d1 = new LinkedList<>();

    private Deque<Integer> d2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        d1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) {
            return -1;
        }

        transfer();

        return d2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) {
            return -1;
        }

        transfer();

        return d2.peek();
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
