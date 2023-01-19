package offer2.p053;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;

        TreeNode node = root;
        while (node != null) {
            if (node.val == p.val) {
                if (node.right == null) {
                    return pre;
                } else {
                    TreeNode right = node.right;
                    while (right.left != null) {
                        right = right.left;
                    }
                    return right;
                }
            } else if (node.val < p.val) {
                node = node.right;
            } else {
                pre = node;
                node = node.left;
            }
        }

        return null;
    }
}
