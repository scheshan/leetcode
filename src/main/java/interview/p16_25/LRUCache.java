package interview.p16_25;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 *
 * @author heshan
 * @date 2023/1/30
 */
public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private Map<Integer, Node> map;

    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity * 2);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        link(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.value = value;
        }
        link(node);

        if (map.size() > capacity) {
            map.remove(tail.key);
            unlink(tail);
        }
    }

    private void link(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        if (node == head) {
            return;
        }

        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;

        if (node == tail) {
            tail = prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    private void unlink(Node node) {
        node.prev.next = null;
        tail = node.prev;
        node.prev = null;
    }
}
