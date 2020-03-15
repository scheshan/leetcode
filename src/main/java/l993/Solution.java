package l993;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private int lx;

    private int ly;

    private int px;

    private int py;

    public boolean isCousins(TreeNode root, int x, int y) {
        travel(root, 0, x, y, 0);

        return lx == ly && px != py;
    }

    private void travel(TreeNode node, int parent, int x, int y, int level) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            lx = level;
            px = parent;
        }
        if (node.val == y) {
            ly = level;
            py = parent;
        }

        travel(node.left, node.val, x, y, level + 1);
        travel(node.right, node.val, x, y, level + 1);
    }
}
