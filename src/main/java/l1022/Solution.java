package l1022;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/14
 */
public class Solution {

    int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        travel(root, 0);

        return result;
    }

    private void travel(TreeNode node, int n) {
        if (node == null) {
            return;
        }

        n = (n << 1) + node.val;

        if (node.left == null && node.right == null) {
            result += n;
            return;
        }

        travel(node.left, n);
        travel(node.right, n);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        new Solution().sumRootToLeaf(root);
    }
}
