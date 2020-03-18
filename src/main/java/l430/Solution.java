package l430;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    private Node prev;

    public Node flatten(Node head) {
        travel(head);

        return head;
    }

    private void travel(Node node) {
        if (node == null) {
            return;
        }

        if (prev == null) {
            prev = node;
        } else {
            prev.next = node;
            node.prev = prev;
            prev = node;
        }

        Node next = node.next;
        travel(node.child);
        node.child = null;
        travel(next);
    }
}
