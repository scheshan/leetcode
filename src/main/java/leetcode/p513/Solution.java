package leetcode.p513;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    int level;
    int res;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        dfs(node.left, level + 1);
        if (level > this.level) {
            this.res = node.val;
            this.level = level;
        }
        dfs(node.right, level + 1);
    }
}
