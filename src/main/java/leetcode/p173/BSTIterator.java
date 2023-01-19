package leetcode.p173;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        while (root != null) {
            stack.addLast(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.removeLast();
        int res = node.val;
        node = node.right;
        while (node != null) {
            stack.addLast(node);
            node = node.left;
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
