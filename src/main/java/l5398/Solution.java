package l5398;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public int goodNodes(TreeNode root) {
        return travel(root, root.val);
    }

    private int travel(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int res = 0;

        if (node.val >= max) {
            res++;
            max = node.val;
        }
        return travel(node.left, max) + travel(node.right, max) + res;
    }
}
