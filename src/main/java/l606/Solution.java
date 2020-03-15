package l606;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        travel(t, sb);

        return sb.toString();
    }

    private void travel(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        if (node.left != null) {
            sb.append("(");
            travel(node.left, sb);
            sb.append(")");
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append("()");
            }

            sb.append("(");
            travel(node.right, sb);
            sb.append(")");
        }
    }
}
