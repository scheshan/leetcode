package l225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MyStack
 *
 * @author heshan
 * @date 2020/3/22
 */
public class MyStack {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()) {
            return -1;
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int v = queue.remove();

            if (i == size - 1) {
                return v;
            }

            queue.add(v);
        }

        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()) {
            return -1;
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            queue.add(v);

            if (i == size - 1) {
                return v;
            }
        }

        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
