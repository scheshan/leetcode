package leetcode.p359;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Logger
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Logger {

    private class Item {
        String message;
        int timestamp;

        public Item(String message, int timestamp) {
            this.message = message;
            this.timestamp = timestamp;
        }
    }

    private Queue<Item> queue;

    private Map<String, Item> map;

    public Logger() {
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10) {
            Item item = queue.remove();
            map.remove(item.message);
        }

        if (map.containsKey(message)) {
            return false;
        }

        Item item = new Item(message, timestamp);
        map.put(message, item);
        queue.add(item);
        return true;
    }
}
