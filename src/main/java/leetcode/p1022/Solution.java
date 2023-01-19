package leetcode.p1022;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int cur) {
        if (node == null) {
            return 0;
        }

        cur <<= 1;
        cur |= node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }

        return dfs(node.left, cur) + dfs(node.right, cur);
    }
}
