package leetcode.p543;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        travel(root);
        return res;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = 0, right = 0;
        if (node.left != null) {
            left = travel(node.left) + 1;
        }
        if (node.right != null) {
            right = travel(node.right) + 1;
        }

        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
