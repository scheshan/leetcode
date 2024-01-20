package leetcode.p138;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
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
        return copyRandomList0(head, new HashMap<>());
    }

    private Node copyRandomList0(Node node, Map<Node, Node> visit) {
        if (node == null) {
            return null;
        }

        if (visit.containsKey(node)) {
            return visit.get(node);
        }

        Node res = new Node(node.val);
        visit.put(node, res);

        res.next = copyRandomList0(node.next, visit);
        res.random = copyRandomList0(node.random, visit);

        return res;
    }
}
