package l124;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        result = Math.max(result, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int r = new Solution().maxPathSum(root);
        System.out.println(r);
    }
}
