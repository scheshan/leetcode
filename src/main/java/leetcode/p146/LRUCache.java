package leetcode.p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache
 *
 * @author heshan
 * @date 2024/2/1
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}
