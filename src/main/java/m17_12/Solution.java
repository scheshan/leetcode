package m17_12;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private TreeNode head;

    private TreeNode prev;

    public TreeNode convertBiNode(TreeNode root) {
        travel(root);

        return head;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }

        travel(node.left);

        node.left = null;
        if (head == null) {
            head = node;
        }
        if (prev != null) {
            prev.right = node;
        }
        prev = node;

        travel(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        new Solution().convertBiNode(root);
    }
}
