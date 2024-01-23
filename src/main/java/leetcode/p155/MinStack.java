package leetcode.p155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class MinStack {

    private class Node {

        private int value;

        private int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private Deque<Node> deque;

    public MinStack() {
        deque = new LinkedList<>();
    }

    public void push(int val) {
        if (deque.isEmpty()) {
            deque.add(new Node(val, val));
            return;
        }

        Node pre = deque.peekLast();
        if (val < pre.min) {
            deque.add(new Node(val, val));
        } else {
            deque.add(new Node(val, pre.min));
        }
    }

    public void pop() {
        deque.removeLast();
    }

    public int top() {
        return deque.peekLast().value;
    }

    public int getMin() {
        return deque.peekLast().min;
    }
}
