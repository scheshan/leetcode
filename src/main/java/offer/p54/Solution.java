package offer.p54;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    private int ind;

    private int res;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.right, k);

        if (ind >= k) {
            return;
        }

        ind++;
        res = node.val;

        dfs(node.left, k);
    }
}
