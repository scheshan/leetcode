package offer2.p056;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (node.val + node.val != k) {
            TreeNode froot = root;
            while (froot != null) {
                if (froot.val == k - node.val) {
                    return true;
                } else if (froot.val > k - node.val) {
                    froot = froot.left;
                } else {
                    froot = froot.right;
                }
            }
        }

        return dfs(root, node.left, k) || dfs(root, node.right, k);
    }
}
