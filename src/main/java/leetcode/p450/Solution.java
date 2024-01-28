package leetcode.p450;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left != null && root.right != null) {
                TreeNode right = root.right;
                while (right.left != null) {
                    right = right.left;
                }
                right.left = root.left;
                return root.right;
            } else if (root.left == null) {
                return root.right;
            } else {
                return root.left;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
