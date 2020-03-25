package l1381;

/**
 * CustomStack
 *
 * @author heshan
 * @date 2020/3/25
 */
public class CustomStack {

    private int maxSize;

    private Node head;

    private int size;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        head = new Node(0);
    }

    public void push(int x) {
        if (size >= maxSize) {
            return;
        }

        Node node = new Node(x);
        node.next = head.next;
        head.next = node;

        size++;
    }

    public int pop() {
        Node node = head.next;
        if (node == null) {
            return -1;
        } else {
            head.next = node.next;
            size--;
            return node.val;
            }
        }

        public void increment(int k, int val) {
            Node node = head.next;
            int i = 0;

            while (node != null) {
                if (i >= size - k) {
                node.val += val;
            }
            node = node.next;
            i++;
        }
    }

    private class Node {

        private Node next;

        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
