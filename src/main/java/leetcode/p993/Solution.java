package leetcode.p993;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/8
 */
public class Solution {

    private TreeNode leftParent;

    private int leftLevel;

    private TreeNode rightParent;

    private int rightLevel;

    public boolean isCousins(TreeNode root, int x, int y) {
        travel(root, x, y, null, 1);

        return leftLevel > 0 && leftLevel == rightLevel && leftParent != rightParent;
    }

    private void travel(TreeNode node, int x, int y, TreeNode parent, int level) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            leftParent = parent;
            leftLevel = level;
        } else if (node.val == y) {
            rightParent = parent;
            rightLevel = level;
        }

        travel(node.left, x, y, node, level + 1);
        travel(node.right, x, y, node, level + 1);
    }
}
