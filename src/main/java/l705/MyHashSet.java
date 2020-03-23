package l705;

/**
 * MyHashSet
 *
 * @author heshan
 * @date 2020/3/23
 */
public class MyHashSet {

    private Node[] items;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        items = new Node[10000];
    }

    public void add(int key) {
        if (find(key) == null) {
            Node node = new Node(key);
            node.next = items[index(key)];
            items[index(key)] = node;
        }
    }

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

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return find(key) != null;
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

        Node next;

        public Node(int key) {
            this.key = key;
        }
    }
}
