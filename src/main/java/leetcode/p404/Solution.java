package leetcode.p404;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return travel(root, false);
    }

    private int travel(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return left ? node.val : 0;
        }

        int res = 0;
        res += travel(node.left, true);
        res += travel(node.right, false);

        return res;
    }
}
