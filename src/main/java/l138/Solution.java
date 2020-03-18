package l138;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        return clone(map, head);
    }

    private Node clone(Map<Node, Node> map, Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            Node clone = new Node(node.val);
            map.put(node, clone);
            clone.random = clone(map, node.random);
            clone.next = clone(map, node.next);
            return clone;
        }
    }
}
