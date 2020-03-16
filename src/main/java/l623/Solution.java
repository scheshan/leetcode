package l623;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }

        if (d == 1) {
            return newNode(v, root, null);
        }

        int level = 1;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> list = queue;
            queue = new LinkedList<>();

            for (TreeNode node : list) {
                if (level == d - 1) {
                    node.left = newNode(v, node.left, null);
                    node.right = newNode(v, null, node.right);
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            level++;
        }

        return root;
    }

    private TreeNode newNode(int v, TreeNode left, TreeNode right) {
        TreeNode node = new TreeNode(v);
        node.left = left;
        node.right = right;
        return node;
    }
}
