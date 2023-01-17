package leetcode.p1038;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    int cnt;

    public TreeNode bstToGst(TreeNode root) {
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
