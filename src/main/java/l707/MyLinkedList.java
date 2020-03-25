package l707;

/**
 * MyLinkedList
 *
 * @author heshan
 * @date 2020/3/25
 */
public class MyLinkedList {

    private Node head;

    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = find(index);
        if (node == null) {
            return -1;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else {
            Node prev = find(index - 1);
            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;

            if (prev == tail) {
                tail = node;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head == null) {
                return;
            }

            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node prev = find(index - 1);
            Node node = prev.next;

            if (node != null) {
                prev.next = node.next;
            }
            if (node == tail) {
                tail = prev;
            }
        }
    }

    private Node find(int index) {
        int i = 0;
        Node node = head;
        while (i < index && node != null) {
            i++;
            node = node.next;
        }

        if (i != index) {
            return null;
        }
        return node;
    }

    private class Node {

        private int val;

        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
