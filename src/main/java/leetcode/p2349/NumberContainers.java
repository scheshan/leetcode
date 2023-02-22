package leetcode.p2349;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * NumberContainers
 *
 * @author heshan
 * @date 2023/2/22
 */
public class NumberContainers {

    private class Item {
        int ind;
        boolean delete;

        public Item(int ind) {
            this.ind = ind;
        }
    }

    Map<Integer, Item> indMap;

    Map<Integer, Queue<Item>> numberMap;

    public NumberContainers() {
        indMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        Item item = indMap.get(index);
        if (item != null) {
            item.delete = true;
        }
        item = new Item(index);
        indMap.put(index, item);

        Queue<Item> queue = numberMap.get(number);
        if (queue == null) {
            queue = createQueue();
            numberMap.put(number, queue);
        }
        queue.add(item);
    }

    public int find(int number) {
        Queue<Item> queue = numberMap.get(number);
        if (queue != null) {
            while (!queue.isEmpty() && queue.peek().delete) {
                queue.remove();
            }
        }

        if (queue == null || queue.isEmpty()) {
            return -1;
        }
        return queue.peek().ind;
    }

    private Queue<Item> createQueue() {
        return new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.ind, o2.ind);
        });
    }
}
