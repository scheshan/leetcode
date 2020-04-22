package l901;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/22
 */
class StockSpanner {

    Deque<Item> deque;

    public StockSpanner() {
        deque = new LinkedList<>();
    }

    public int next(int price) {
        Item item = new Item();
        item.price = price;
        item.count = 1;
        while (!deque.isEmpty() && deque.peekLast().price <= price) {
            item.count += deque.removeLast().count;
        }

        deque.addLast(item);
        return item.count;
    }

    private class Item {

        private int price;

        private int count;
    }
}
