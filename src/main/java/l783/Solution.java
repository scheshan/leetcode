package l783;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private int min = Integer.MAX_VALUE;

    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        travel(root);

        return min;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }

        travel(node.left);

        if (prev != null) {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;

        travel(node.right);
    }
}
