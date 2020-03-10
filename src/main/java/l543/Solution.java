package l543;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);

        return Math.max(0, max - 1);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        int h = left + right + 1;
        if (h > max) {
            max = h;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        new Solution().diameterOfBinaryTree(root);
    }
}
