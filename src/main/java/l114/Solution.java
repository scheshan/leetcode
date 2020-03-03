package l114;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public void flatten(TreeNode root) {
        travel(root);
    }

    private TreeNode travel(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return travel(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return travel(root.right);
        } else {
            TreeNode leftTail = travel(root.left);
            TreeNode rightTail = travel(root.right);
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;

            return rightTail;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        new Solution().flatten(root);
    }
}
