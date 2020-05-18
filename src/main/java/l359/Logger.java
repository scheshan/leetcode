package l359;

import java.util.HashMap;
import java.util.Map;

/**
 * Logger
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Logger {

    private Map<String, Integer> history;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        history = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!history.containsKey(message) || history.get(message) <= timestamp - 10) {
            history.put(message, timestamp);
            return true;
        }
        return false;
    }

    private class Item {

        String message;

        int timestamp;

        public Item(String message, int timestamp) {
            this.message = message;
            this.timestamp = timestamp;
        }
    }
}
