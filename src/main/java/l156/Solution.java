package l156;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    private TreeNode head;

    private TreeNode tail;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        travel(root, true);

        return head;
    }

    private void travel(TreeNode node, boolean right) {
        if (node == null) {
            return;
        }

        travel(node.left, true);
        travel(node.right, false);

        node.left = null;
        node.right = null;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (right) {
                tail.right = node;
                tail = node;
            } else {
                tail.left = node;
            }
        }
    }
}
