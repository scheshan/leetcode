package l129;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int n) {
        if (node == null) {
            return 0;
        }

        //is leaf
        if (node.left == null && node.right == null) {
            return n * 10 + node.val;
        }

        n = n * 10 + node.val;
        return dfs(node.left, n) + dfs(node.right, n);
    }
}
