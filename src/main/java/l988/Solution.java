package l988;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {
    private String result;

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        travel(root, sb);

        return result;
    }

    private void travel(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            sb.reverse();
            String str = sb.toString();
            if (result == null) {
                result = str;
            } else if (result.compareTo(str) > 0) {
                result = str;
            }
            sb.reverse();
        }

        travel(node.left, sb);
        travel(node.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}
