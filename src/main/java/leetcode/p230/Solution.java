package leetcode.p230;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    int ind;

    int res;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.left, k);

        if (ind >= k) {
            return;
        }

        ind++;
        res = node.val;

        dfs(node.right, k);
    }
}
