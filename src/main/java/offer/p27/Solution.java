package offer.p27;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);

        return root;
    }
}
