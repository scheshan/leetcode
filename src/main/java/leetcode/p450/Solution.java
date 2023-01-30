package leetcode.p450;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                insertLeft(root.right, root.left);
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private void insertLeft(TreeNode right, TreeNode node) {
        TreeNode pre = right;
        TreeNode cur = right.left;
        while (cur != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = node;
    }
}
