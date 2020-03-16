package l173;

import shared.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BSTIterator
 *
 * @author heshan
 * @date 2020/3/16
 */
class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();

        fillLeft(root);
    }

    private void fillLeft(TreeNode node) {
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) {
            return -1;
        }

        TreeNode node = stack.removeFirst();
        fillLeft(node.right);

        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
