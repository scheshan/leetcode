package l285;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    TreeNode res;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        travel(root, p);
        return res;
    }

    private void travel(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }

        if (node.val > p.val) {
            res = node;
            travel(node.left, p);
        } else if (node.val < p.val) {
            travel(node.right, p);
        } else {
            if (node.right != null) {
                travel(node.right, p);
            }
        }
    }
}
