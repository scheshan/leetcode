package leetcode.p1472;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class BrowserHistory {

    private class Node {
        String url;
        Node next;
        Node prev;

        public Node(String url) {
            this.url = url;
        }
    }

    private Node head;

    private Node tail;

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public String back(int steps) {
        Node node = tail;
        for (int i = 0; i < steps && node != head; i++) {
            node = node.prev;
        }
        tail = node;
        return node.url;
    }

    public String forward(int steps) {
        Node node = tail;
        for (int i = 0; i < steps && node.next != null; i++) {
            node = node.next;
        }
        tail = node;
        return node.url;
    }
}
