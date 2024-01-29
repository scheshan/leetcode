package lcr.p154;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    public Node copyRandomList(Node head) {
        return copy(head, new HashMap<>());
    }

    private Node copy(Node head, Map<Node, Node> cache) {
        if (head == null) {
            return null;
        }
        if (cache.containsKey(head)) {
            return cache.get(head);
        }

        Node res = new Node(head.val);
        cache.put(head, res);

        res.next = copy(head.next, cache);
        res.random = copy(head.random, cache);

        return res;
    }
}
