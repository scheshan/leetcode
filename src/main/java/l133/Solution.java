package l133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node clone = visited.get(node);
        if (clone != null) {
            return clone;
        }

        clone = new Node(node.val);
        visited.put(node, clone);

        clone.neighbors = new LinkedList<>();
        for (Node n : node.neighbors) {
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }
}
