package leetcode.p513;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    private int level;

    private int res;

    public int findBottomLeftValue(TreeNode root) {
        level = -1;

        travel(root, 0);

        return res;
    }

    private void travel(TreeNode node, int l) {
        if (node == null) {
            return;
        }

        if (l > level) {
            level = l;
            res = node.val;
        }

        travel(node.left, l + 1);
        travel(node.right, l + 1);
    }
}
