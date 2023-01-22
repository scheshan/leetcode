package leetcode.p998;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
