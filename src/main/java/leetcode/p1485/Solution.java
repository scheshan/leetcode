package leetcode.p1485;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
class Node {
    int val;
    Node left;
    Node right;
    Node random;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy extends Node {

    public NodeCopy(int val) {
        super(val);
    }
}

public class Solution {

    public NodeCopy copyRandomBinaryTree(Node root) {
        return copy(root, new HashMap<>());
    }

    private NodeCopy copy(Node node, Map<Node, NodeCopy> cache) {
        if (node == null) {
            return null;
        }

        if (cache.containsKey(node)) {
            return cache.get(node);
        }

        NodeCopy res = new NodeCopy(node.val);
        cache.put(node, res);

        res.left = copy(node.left, cache);
        res.right = copy(node.right, cache);
        res.random = copy(node.random, cache);

        return res;
    }
}
