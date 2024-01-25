package leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MyStack
 *
 * @author heshan
 * @date 2024/1/25
 */
public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }

    public int top() {
        if (empty()) {
            return 0;
        }

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }

        int res = queue.remove();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
