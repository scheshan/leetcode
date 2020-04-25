package l426;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    private Node dummy = new Node(0);

    private Node tail = dummy;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        travel(root);

        tail.right = dummy.right;
        dummy.right.left = tail;

        return dummy.right;
    }

    private void travel(Node node) {
        if (node == null) {
            return;
        }

        travel(node.left);

        node.left = tail;
        tail.right = node;
        tail = node;

        travel(node.right);
    }
}
