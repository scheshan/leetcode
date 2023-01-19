package offer2.p052;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    private TreeNode head;

    private TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (head == null) {
            head = node;
        } else {
            tail.right = node;
        }
        node.left = null;
        tail = node;
        dfs(node.right);
    }
}
