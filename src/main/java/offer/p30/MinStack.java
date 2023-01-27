package offer.p30;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MinStack
 *
 * @author heshan
 * @date 2023/1/27
 */
public class MinStack {

    private class Item {
        int value;
        int min;
    }

    Deque<Item> deque = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int x) {
        Item item = new Item();
        item.value = x;
        item.min = x;
        if (!deque.isEmpty() && deque.peekLast().min < x) {
            item.min = deque.peekLast().min;
        }
        deque.addLast(item);
    }

    public void pop() {
        deque.removeLast();
    }

    public int top() {
        return deque.peekLast().value;
    }

    public int min() {
        return deque.peekLast().min;
    }
}
