package leetcode.p155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class MinStack {

    private Deque<int[]> deque;

    public MinStack() {
        deque = new LinkedList<>();
    }

    public void push(int val) {
        int[] arr = new int[]{val, val};
        if (!deque.isEmpty()) {
            int[] pre = deque.peekLast();
            arr[1] = Math.min(arr[1], pre[1]);
        }
        deque.addLast(arr);
    }

    public void pop() {
        deque.removeLast();
    }

    public int top() {
        return deque.peekLast()[0];
    }

    public int getMin() {
        return deque.peekLast()[1];
    }
}
