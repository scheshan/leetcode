package leetcode.p707;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class MyLinkedList {

    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        Node node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }

        if (node == null) {
            return -1;
        }
        return node.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node pre = null;
        Node node = head;
        while (index > 0 && node != null) {
            pre = node;
            node = node.next;
            index--;
        }
        Node newNode = new Node(val);
        pre.next = newNode;
        newNode.prev = pre;
        newNode.next = node;
        node.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size == 0 || index >= size) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node pre = null;
            Node node = head;
            while (index > 0 && node != null) {
                pre = node;
                node = node.next;
                index--;
            }
            pre.next = pre.next.next;
            pre.next.prev = pre;
        }
        size--;
    }
}
