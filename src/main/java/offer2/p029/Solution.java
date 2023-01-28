package offer2.p029;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node res = new Node(insertVal);
        if (head == null) {
            res.next = res;
            return res;
        }

        int min = head.val;
        int max = head.val;
        Node tail = head;

        Node node = head.next;
        while (node != head) {
            if (node.val >= max) {
                max = node.val;
                tail = node;
            }
            if (node.val < min) {
                min = node.val;
            }
            node = node.next;
        }

        if (insertVal >= max || insertVal <= min) {
            Node next = tail.next;
            tail.next = res;
            res.next = next;
        } else {
            node = head;
            while (true) {
                if (node.val <= insertVal && node.next.val > insertVal) {
                    Node next = node.next;
                    node.next = res;
                    res.next = next;
                    break;
                }
                node = node.next;
            }
        }
        return head;
    }
}
