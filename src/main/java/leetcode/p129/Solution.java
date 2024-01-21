package leetcode.p129;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    private int res;

    public int sumNumbers(TreeNode root) {
        travel(root, 0);

        return res;
    }

    private void travel(TreeNode node, int n) {
        if (node == null) {
            return;
        }

        n = n * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += n;
        } else {
            travel(node.left, n);
            travel(node.right, n);
        }
    }
}
