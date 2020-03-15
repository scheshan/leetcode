package l112;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private boolean result;

    public boolean hasPathSum(TreeNode root, int sum) {
        travel(root, sum, 0);

        return result;
    }

    private void travel(TreeNode node, int sum, int cur) {
        if (node == null || result) {
            return;
        }

        cur += node.val;
        if (sum == cur && node.left == null && node.right == null) {
            result = true;
            return;
        }

        travel(node.left, sum, cur);
        travel(node.right, sum, cur);
    }
}
