package leetcode.p432;

import java.util.HashMap;
import java.util.Map;

/**
 * AllOne
 *
 * @author heshan
 * @date 2023/2/1
 */
public class AllOne {

    private class Node {
        String key;
        int count;
        Node prev;
        Node next;

        public Node(String key) {
            this.key = key;
        }
    }

    private Node head;

    private Node tail;

    private Map<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
    }

    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key);
            map.put(key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        node.count++;
        while (node.prev != null && node.count > node.prev.count) {
            swap(node.prev, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.count--;

        while (node.next != null && node.count < node.next.count) {
            swap(node, node.next);
        }

        if (node.count == 0) {
            Node prev = node.prev;
            if (prev != null) {
                prev.next = node.next;
            } else {
                head = node.next;
            }
            Node next = node.next;
            if (next != null) {
                next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            map.remove(node.key);
        }
    }

    public String getMaxKey() {
        if (head != null) {
            return head.key;
        }
        return "";
    }

    public String getMinKey() {
        if (tail != null) {
            return tail.key;
        }
        return "";
    }

    private void swap(Node left, Node right) {
        Node leftPrev = left.prev;
        Node rightNext = right.next;

        if (leftPrev == null) {
            head = right;
        } else {
            leftPrev.next = right;
        }
        if (rightNext == null) {
            tail = left;
        } else {
            rightNext.prev = left;
        }

        left.next = rightNext;
        left.prev = right;
        right.next = left;
        right.prev = leftPrev;
    }
}
