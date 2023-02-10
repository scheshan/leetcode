package leetcode.p1797;

import java.util.*;

/**
 * AuthenticationManager
 *
 * @author heshan
 * @date 2023/2/1
 */
public class AuthenticationManager {

    private class Item {
        String key;
        int timestamp;

        public Item(String key, int timestamp) {
            this.key = key;
            this.timestamp = timestamp;
        }
    }

    private Map<String, Item> map;

    private Queue<Item> queue;

    private int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public void generate(String tokenId, int currentTime) {
        prune(currentTime);

        Item item = new Item(tokenId, currentTime + ttl);
        map.put(tokenId, item);
        queue.add(item);
    }

    public void renew(String tokenId, int currentTime) {
        prune(currentTime);

        if (!map.containsKey(tokenId)) {
            return;
        }
        Item item = new Item(tokenId, currentTime + ttl);
        map.put(tokenId, item);
        queue.add(item);
    }

    public int countUnexpiredTokens(int currentTime) {
        prune(currentTime);

        return map.size();
    }

    private void prune(int currentTime) {
        while (!queue.isEmpty() && queue.peek().timestamp <= currentTime) {
            Item item = queue.peek();
            if (map.get(item.key).timestamp == item.timestamp) {
                map.remove(item.key);
            }
            queue.remove();
        }
    }
}
