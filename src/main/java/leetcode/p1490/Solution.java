package leetcode.p1490;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {

    public Node cloneTree(Node root) {
        return clone(root, new HashMap<>());
    }

    private Node clone(Node node, Map<Node, Node> cache) {
        if (node == null) {
            return null;
        }

        if (cache.containsKey(node)) {
            return cache.get(node);
        }

        Node res = new Node(node.val);
        cache.put(node, res);

        for (Node child : node.children) {
            res.children.add(clone(child, cache));
        }

        return res;
    }
}
