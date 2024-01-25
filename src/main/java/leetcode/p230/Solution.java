package leetcode.p230;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    private int res;

    private int cur;

    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);

        return res;
    }

    private void travel(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        travel(node.left, k);

        cur++;
        if (cur >= k) {
            if (cur == k) {
                res = node.val;
            }
            return;
        }

        travel(node.right, k);
    }
}
