package leetcode.p1038;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    private int pre;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = bstToGst(root.right);

        pre += root.val;
        root.val = pre;

        root.left = bstToGst(root.left);

        return root;
    }
}
