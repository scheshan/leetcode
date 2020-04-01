package l155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * MinStack
 *
 * @author heshan
 * @date 2020/4/1
 */
public class MinStack {

    private Deque<Item> deque = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        Item item = new Item();
        item.value = x;

        if (deque.isEmpty()) {
            item.min = x;
        } else {
            Item prev = deque.peekLast();
            item.min = Math.min(prev.min, x);
        }
        deque.addLast(item);
    }

    public void pop() {
        if (!deque.isEmpty()) {
            deque.removeLast();
        }
    }

    public int top() {
        return deque.peekLast().value;
    }

    public int getMin() {
        return deque.peekLast().min;
    }

    private class Item {

        private int value;

        private int min;
    }
}
