package m36;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    private Node dummy = new Node();

    private Node cur = dummy;

    public Node treeToDoublyList(Node root) {
        travel(root);

        if (cur != dummy) {
            cur.right = dummy.right;
            dummy.right.left = cur;
        }

        return dummy.right;
    }

    private void travel(Node node) {
        if (node == null) {
            return;
        }

        travel(node.left);

        cur.right = node;
        node.left = cur;
        cur = node;

        travel(node.right);
    }
}
