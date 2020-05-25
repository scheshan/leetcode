package l146;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/25
 */
public class LRUCache {

    private int capacity;

    private Entry head;

    private Entry tail;

    private Map<Integer, Entry> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity * 3 / 2);
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return -1;
        }
        unlink(entry);
        addToHead(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        Entry entry = map.get(key);
        if (entry == null) {
            entry = new Entry();
            entry.key = key;
            map.put(key, entry);
        }
        entry.value = value;
        unlink(entry);
        addToHead(entry);

        while (map.size() > capacity) {
            Entry e = tail;
            map.remove(e.key);
            unlink(e);
        }
    }

    private void addToHead(Entry entry) {
        if (head == null) {
            tail = entry;
        } else {
            entry.next = head;
            head.prev = entry;
        }
        head = entry;
    }

    private void unlink(Entry entry) {
        if (head == entry) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        if (tail == entry) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }

        if (entry.prev != null) {
            entry.prev.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.prev = entry.prev;
        }

        entry.prev = null;
        entry.next = null;
    }

    private class Entry {

        private Entry prev;

        private Entry next;

        private int key;

        private int value;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
    }
}
