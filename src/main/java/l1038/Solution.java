package l1038;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    private int cur = 0;

    public TreeNode bstToGst(TreeNode root) {
        travel(root);

        return root;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }

        travel(root.right);

        root.val += cur;
        cur = root.val;

        travel(root.left);
    }
}
