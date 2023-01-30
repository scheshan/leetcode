package leetcode.p671;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    private int min;

    private Integer res;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return res == null ? -1 : res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (node.val > min) {
                if (res == null) {
                    res = node.val;
                } else {
                    res = Math.min(node.val, res);
                }
            }
        } else {
            dfs(node.left);
            dfs(node.right);
        }
    }
}
