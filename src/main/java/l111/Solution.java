package l111;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private int result = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        travel(root, 0);
        return result;
    }

    private void travel(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        depth++;

        if (node.left == null && node.right == null) {
            result = Math.min(result, depth);
        }

        if (depth >= result) {
            return;
        }
        travel(node.left, depth);
        travel(node.right, depth);
    }
}
