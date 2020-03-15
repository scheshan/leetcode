package l110;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxHeight(root);

        return result;
    }

    private int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxHeight(node.left);
        int right = maxHeight(node.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return Math.max(left, right) + 1;
    }
}
