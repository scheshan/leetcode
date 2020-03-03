package l1315;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        return sum(root, false, false);
    }

    private int sum(TreeNode root, boolean parent, boolean grand) {
        if (root == null) {
            return 0;
        }
        int n = 0;
        if (grand) {
            n = root.val;
        }
        boolean m = match(root);
        return sum(root.left, m, parent) + sum(root.right, m, parent) + n;
    }

    private boolean match(TreeNode node) {
        return node != null && (node.val & 1) != 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        new Solution().sumEvenGrandparent(root);
    }
}
