package leetcode.p230;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    private int cur = 0;

    private int res;

    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);
        return res;
    }

    private void travel(TreeNode node, int k) {
        if (node == null || cur >= k) {
            return;
        }

        travel(node.left, k);

        if (cur < k) {
            cur++;
            res = node.val;
        }

        travel(node.right, k);
    }
}
