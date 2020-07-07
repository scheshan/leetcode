package l112;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        return travel(root, sum);
    }

    private boolean travel(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }

        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            return true;
        }

        return travel(node.left, sum) || travel(node.right, sum);
    }
}
