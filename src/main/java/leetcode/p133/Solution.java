package leetcode.p133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return cloneGraph0(node, new HashMap<>());
    }

    private Node cloneGraph0(Node node, Map<Integer, Node> cache) {
        if (node == null) {
            return null;
        }

        if (cache.containsKey(node.val)) {
            return cache.get(node.val);
        }

        Node res = new Node(node.val);
        cache.put(node.val, res);

        for (Node neighbor : node.neighbors) {
            res.neighbors.add(cloneGraph0(neighbor, cache));
        }

        return res;
    }
}
