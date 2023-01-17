package leetcode.p538;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    int cnt;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.right);
        node.val += cnt;
        cnt = node.val;
        dfs(node.left);
    }
}
