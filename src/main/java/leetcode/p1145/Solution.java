package leetcode.p1145;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    private int left;

    private int right;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x, 0);

        if (left * 2 > n || right * 2 > n || (n - left - right - 1) * 2 > n) {
            return true;
        }
        return false;
    }

    private void dfs(TreeNode node, int x, int type) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            dfs(node.left, x, -1);
            dfs(node.right, x, 1);
        } else {
            if (type < 0) {
                left++;
            } else if (type > 0) {
                right++;
            }
            dfs(node.left, x, type);
            dfs(node.right, x, type);
        }
    }
}
