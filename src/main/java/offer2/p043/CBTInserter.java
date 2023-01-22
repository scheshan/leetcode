package offer2.p043;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class CBTInserter {

    private Queue<TreeNode> queue;

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left == null || node.right == null) {
                return;
            }
            node = queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        if (node.left == null) {
            node.left = new TreeNode(v);
        } else if (node.right == null) {
            node.right = new TreeNode(v);
            queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
