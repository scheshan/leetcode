package leetcode.p2034;

import java.util.*;

/**
 * StockPrice
 *
 * @author heshan
 * @date 2023/2/4
 */
public class StockPrice {

    private class Item {
        int price;
        boolean deleted;

        public Item(int price) {
            this.price = price;
        }
    }

    private Map<Integer, Item> timeMap;

    private Queue<Item> minQueue;

    private Queue<Item> maxQueue;

    private int latest;

    public StockPrice() {
        timeMap = new HashMap<>();

        Comparator<Item> min = Comparator.comparingInt(o -> o.price);
        minQueue = new PriorityQueue<>(min);
        maxQueue = new PriorityQueue<>((o1, o2) -> -min.compare(o1, o2));
    }

    public void update(int timestamp, int price) {
        if (timeMap.containsKey(timestamp)) {
            timeMap.get(timestamp).deleted = true;
        }
        Item item = new Item(price);
        timeMap.put(timestamp, item);
        minQueue.add(item);
        maxQueue.add(item);

        if (timestamp > latest) {
            latest = timestamp;
        }
    }

    public int current() {
        return timeMap.get(latest).price;
    }

    public int maximum() {
        prune(maxQueue);
        return maxQueue.peek().price;
    }

    public int minimum() {
        prune(minQueue);
        return minQueue.peek().price;
    }

    private void prune(Queue<Item> queue) {
        while (!queue.isEmpty() && queue.peek().deleted) {
            queue.remove();
        }
    }
}
