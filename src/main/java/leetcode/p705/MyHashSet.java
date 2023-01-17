package leetcode.p705;

/**
 * MyHashSet
 *
 * @author heshan
 * @date 2023/1/17
 */
public class MyHashSet {

    private class Node {
        private int key;
        private Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node[] items;

    private int mask;

    public MyHashSet() {
        int buckets = 2 << 10;
        items = new Node[buckets];
        mask = buckets - 1;
    }

    public void add(int key) {
        int ind = key & mask;
        Node head = items[ind];
        if (head == null) {
            items[ind] = new Node(key);
            return;
        }
        while (head != null) {
            if (head.key == key) {
                return;
            }
            head = head.next;
        }
        head = new Node(key);
        head.next = items[ind];
        items[ind] = head;
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

    public boolean contains(int key) {
        int ind = key & mask;
        Node head = items[ind];

        while (head != null) {
            if (head.key == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
