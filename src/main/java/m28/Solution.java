package m28;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/14
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            if (node1.val != node2.val) {
                return false;
            }

            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        new Solution().isSymmetric(root);
    }
}
