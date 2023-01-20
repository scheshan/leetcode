package leetcode.p701;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.right == null) {
            root.right = new TreeNode(val);
            return root;
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
