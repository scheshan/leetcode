package l230;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    private int cur = 0;

    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);

        cur++;
        if (cur == k) {
            result = root.val;
            return;
        } else if (cur > k) {
            return;
        }

        dfs(root.right, k);
    }
}
