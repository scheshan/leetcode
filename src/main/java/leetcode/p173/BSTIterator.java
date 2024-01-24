package leetcode.p173;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BSTIterator
 *
 * @author heshan
 * @date 2024/1/24
 */
public class BSTIterator {

    private Deque<TreeNode> deque;

    public BSTIterator(TreeNode root) {
        deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
        }
    }

    public int next() {
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == null) {
                node = deque.removeLast();
                return node.val;
            } else {
                if (node.right != null) {
                    deque.addLast(node.right);
                }

                deque.addLast(node);
                deque.addLast(null);

                if (node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }

        return 0;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}
