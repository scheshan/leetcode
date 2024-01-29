package leetcode.p129;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        return travel(root, 0);
    }

    private int travel(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }

        path = path * 10 + node.val;
        if (node.left == null && node.right == null) {
            return path;
        } else {
            return travel(node.left, path) + travel(node.right, path);
        }
    }
}
