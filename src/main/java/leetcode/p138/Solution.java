package leetcode.p138;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

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

    public Node copyRandomList(Node head) {
        return copy(head, new HashMap<Node, Node>());
    }

    private Node copy(Node node, Map<Node, Node> visit) {
        if (node == null) {
            return null;
        }

        if (visit.containsKey(node)) {
            return visit.get(node);
        }

        Node res = new Node(node.val);
        visit.put(node, res);

        res.next = copy(node.next, visit);
        res.random = copy(node.random, visit);

        return res;
    }
}
