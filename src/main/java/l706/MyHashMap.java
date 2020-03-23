package l706;

/**
 * MyHashMap
 *
 * @author heshan
 * @date 2020/3/23
 */
public class MyHashMap {

    private Node[] items;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        items = new Node[10000];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node node = find(key);
        if (node == null) {
            node = new Node(key, value);
            node.next = items[index(key)];
            items[index(key)] = node;
        } else {
            node.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node node = find(key);
        if (node == null) {
            return -1;
        }
        return node.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node head = items[index(key)];

        if (head == null) {
            return;
        }

        if (head.key == key) {
            items[index(key)] = head.next;
        }


        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                break;
            }

            prev = cur;
            cur = cur.next;
        }
    }

    private Node find(int key) {
        Node head = items[index(key)];
        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.key == key) {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    private int index(int key) {
        return key % items.length;
    }

    private class Node {

        int key;

        int value;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
