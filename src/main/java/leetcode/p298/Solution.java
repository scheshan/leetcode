package leetcode.p298;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int longestConsecutive(TreeNode root) {
        return dfs(root, root.val + 1, 1);
    }

    private int dfs(TreeNode node, int preVal, int length) {
        if (node == null) {
            return 0;
        }

        int res = 1;
        if (node.val == preVal) {
            res += length;
            length++;
        } else {
            length = 1;
        }

        res = Math.max(res, dfs(node.left, node.val, length));
        res = Math.max(res, dfs(node.right, node.val, length));
        return res;
    }
}
