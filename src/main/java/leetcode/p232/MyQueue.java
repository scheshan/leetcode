package leetcode.p232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class MyQueue {

    private Deque<Integer> d1;

    private Deque<Integer> d2;

    public MyQueue() {
        d1 = new ArrayDeque<>();
        d2 = new ArrayDeque<>();
    }

    public void push(int x) {
        d2.addLast(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        transfer();
        return d1.removeLast();
    }

    public int peek() {
        if(empty()) {
            return -1;
        }

        transfer();
        return d1.peekLast();
    }

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
