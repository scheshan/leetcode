package interview.p59_02;

import java.util.*;

/**
 * MaxQueue
 *
 * @author heshan
 * @date 2023/2/1
 */
public class MaxQueue {

    private class Item {
        int value;
        boolean deleted;

        public Item(int value) {
            this.value = value;
        }
    }

    private Queue<Item> queue;

    private Deque<Item> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst().value;
    }

    public void push_back(int value) {
        Item item = new Item(value);
        queue.add(item);
        while(!maxQueue.isEmpty() && maxQueue.peekLast().value < item.value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(item);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Item item = queue.remove();
        item.deleted = true;

        prune();

        return item.value;
    }

    private void prune() {
        while (!maxQueue.isEmpty() && maxQueue.peekFirst().deleted) {
            maxQueue.removeFirst();
        }
    }
}
