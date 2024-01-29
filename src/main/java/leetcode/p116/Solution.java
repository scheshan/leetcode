package leetcode.p116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (pre != null) pre.next = node;
                pre = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return root;
    }
}
