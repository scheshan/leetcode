package leetcode.p133;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/31
 */
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

public class Solution {

    public Node cloneGraph(Node node) {
        Node[] cache = new Node[101];
        return clone(node, cache);
    }

    private Node clone(Node node, Node[] cache) {
        if (node == null) {
            return null;
        }
        if (cache[node.val] != null) {
            return cache[node.val];
        }

        Node res = new Node(node.val);
        cache[node.val] = res;

        for (Node next : node.neighbors) {
            res.neighbors.add(clone(next, cache));
        }

        return res;
    }
}
