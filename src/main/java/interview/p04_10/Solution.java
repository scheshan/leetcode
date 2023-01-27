package interview.p04_10;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    private boolean res;

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        int hash = hash(t2);
        dfs(t1, t2, hash);
        return res;
    }

    private int hash(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = hash(node.left);
        int right = hash(node.right);

        return (left << 16) + right + node.val;
    }

    private int dfs(TreeNode node, TreeNode t2, int target) {
        if (node == null || res) {
            return 0;
        }

        int left = dfs(node.left, t2, target);
        int right = dfs(node.right, t2, target);
        int hash = (left << 16) + right + node.val;
        if (hash == target && isSame(node, t2)) {
            res = true;
        }
        return hash;
    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
        }
        return false;
    }
}
