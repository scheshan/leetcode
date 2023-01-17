package leetcode.p706;

/**
 * MyHashMap
 *
 * @author heshan
 * @date 2023/1/17
 */
public class MyHashMap {

    private class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] items;

    private int mask;

    public MyHashMap() {
        int buckets = 2 << 10;
        items = new Node[buckets];
        mask = buckets - 1;
    }

    public void put(int key, int value) {
        int ind = key & mask;
        Node head = items[ind];
        if (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = new Node(key, value);
        head.next = items[ind];
        items[ind] = head;
    }

    public int get(int key) {
        int ind = key & mask;
        Node head = items[ind];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int ind = key & mask;
        Node head = items[ind];
        if (head == null) {
            return;
        }
        if (head.key == key) {
            items[ind] = head.next;
            return;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.key == key) {
                pre.next = cur.next;
                cur.next = null;
                return;
            }

            pre = cur;
            cur = cur.next;
        }
    }
}
