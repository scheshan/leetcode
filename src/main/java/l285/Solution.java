package l285;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;

        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res;
    }
}
