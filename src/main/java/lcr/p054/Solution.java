package lcr.p054;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    private int pre;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = convertBST(root.right);

        pre += root.val;
        root.val = pre;

        root.left = convertBST(root.left);

        return root;
    }
}
