package leetcode.p98;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        Integer pre = null;

        if (root != null) {
            deque.addLast(root);
        }

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == null) {
                node = deque.removeLast();
                if (pre != null && node.val <= pre) {
                    return false;
                }
                pre = node.val;
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

        return true;
    }
}
