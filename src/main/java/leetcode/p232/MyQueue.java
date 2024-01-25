package leetcode.p232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * MyQueue
 *
 * @author heshan
 * @date 2024/1/25
 */
public class MyQueue {

    private Deque<Integer> d1;

    private Deque<Integer> d2;

    public MyQueue() {
        d1 = new LinkedList<>();
        d2 = new LinkedList<>();
    }

    public void push(int x) {
        d1.addLast(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }
        transfer();
        return d2.removeLast();
    }

    public int peek() {
        if (empty()) {
            return 0;
        }
        transfer();
        return d2.peekLast();
    }

    public boolean empty() {
        return d1.isEmpty() && d2.isEmpty();
    }

    private void transfer() {
        if (!d2.isEmpty()) {
            return;
        }
        while (!d1.isEmpty()) {
            d2.addLast(d1.removeLast());
        }
    }
}
