package leetcode.p606;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        if (node.left != null) {
            sb.append('(');
            dfs(node.left, sb);
            sb.append(')');
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append("()");
            }

            sb.append('(');
            dfs(node.right, sb);
            sb.append(')');
        }
    }
}
