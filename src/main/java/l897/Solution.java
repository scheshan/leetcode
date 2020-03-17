package l897;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/17
 */
public class Solution {

    TreeNode head;

    TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {
        travel(root);

        return head;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }

        travel(node.left);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.right = node;
            tail = node;
        }

        node.left = null;

        travel(node.right);
    }
}
