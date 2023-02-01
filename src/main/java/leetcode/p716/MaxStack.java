package leetcode.p716;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MaxStack
 *
 * @author heshan
 * @date 2023/2/1
 */
public class MaxStack {

    private class Item {
        int value;

        boolean deleted;

        int index;

        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private Deque<Item> deque;

    private Queue<Item> queue;

    private int ind;

    public MaxStack() {
        deque = new ArrayDeque<>(10000);
        queue = new PriorityQueue<>(10000, this::compare);
    }

    private int compare(Item a, Item b) {
        int c = Integer.compare(b.value, a.value);
        if (c == 0) {
            return Integer.compare(b.index, a.index);
        }
        return c;
    }

    public void push(int x) {
        Item item = new Item(x, ind++);
        deque.addLast(item);
        queue.add(item);
    }

    public int pop() {
        pruneStack();
        Item item = deque.removeLast();
        item.deleted = true;
        return item.value;
    }

    public int top() {
        pruneStack();
        Item item = deque.peekLast();
        return item.value;
    }

    public int peekMax() {
        pruneQueue();
        return queue.peek().value;
    }

    public int popMax() {
        pruneQueue();
        Item item = queue.remove();
        item.deleted = true;
        return item.value;
    }

    private void pruneQueue() {
        while (!queue.isEmpty() && queue.peek().deleted) {
            queue.remove();
        }
    }

    private void pruneStack() {
        while (!deque.isEmpty() && deque.peekLast().deleted) {
            deque.removeLast();
        }
    }
}
