package interview.p04_06;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        TreeNode node = root;
        while (node != p) {
            if (node.val > p.val) {
                pre = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node.right != null) {
            TreeNode right = node.right;
            if (right != null) {
                while (right.left != null) {
                    right = right.left;
                }
            }
            return right;
        } else {
            return pre;
        }
    }
}
