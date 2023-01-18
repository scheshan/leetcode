package leetcode.p617;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 != null) {
            TreeNode left = mergeTrees(root1.left, root2.left);
            TreeNode right = mergeTrees(root1.right, root2.right);
            root1.left = left;
            root1.right = right;
            root1.val += root2.val;
            return root1;
        } else if (root1 != null) {
            return root1;
        } else {
            return root2;
        }
    }
}
