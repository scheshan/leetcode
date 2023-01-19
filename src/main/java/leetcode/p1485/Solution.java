package leetcode.p1485;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public class Node {
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

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> visit = new HashMap<>();
        return copy(root, visit);
    }

    private NodeCopy copy(Node node, Map<Node, NodeCopy> visit) {
        if (node == null) {
            return null;
        }

        if (visit.containsKey(node)) {
            return visit.get(node);
        }

        NodeCopy res = new NodeCopy(node.val);
        visit.put(node, res);
        res.left = copy(node.left, visit);
        res.right = copy(node.right, visit);
        res.random = copy(node.random, visit);
        return res;
    }
}
