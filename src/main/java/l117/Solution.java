package l117;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        List<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Node> list = queue;
            queue = new LinkedList<>();

            Node cur = null;
            for (Node node : list) {
                if (cur != null) {
                    cur.next = node;
                }
                cur = node;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
}
