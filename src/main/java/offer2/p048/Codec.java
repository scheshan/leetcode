package offer2.p048;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left != null) {
            sb.append('(');
            serialize(node.left, sb);
            sb.append(')');
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append("()");
            }
            sb.append('(');
            serialize(node.right, sb);
            sb.append(')');
        }
    }

    private int ind;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (ind >= data.length() || data.charAt(ind) == ')') {
            return null;
        }

        TreeNode node = new TreeNode(0);
        int multi = 1;
        if (data.charAt(ind) == '-') {
            multi = -1;
            ind++;
        }

        while (ind < data.length() && data.charAt(ind) >= '0' && data.charAt(ind) <= '9') {
            node.val = node.val * 10 + data.charAt(ind) - '0';
            ind++;
        }
        node.val *= multi;

        if (ind < data.length() && data.charAt(ind) == '(') {
            ind++;
            node.left = deserialize(data);
            ind++;
        }
        if (ind < data.length() && data.charAt(ind) == '(') {
            ind++;
            node.right = deserialize(data);
            ind++;
        }
        return node;
    }
}
