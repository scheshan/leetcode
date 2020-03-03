package m54;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    private int result;

    private int cur;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.right, k);

        cur++;
        if (cur == k) {
            result = root.val;
        }

        if (cur < k) {
            dfs(root.left, k);
        }
    }
}
