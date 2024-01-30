package leetcode.p94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == null) {
                res.add(deque.removeLast().val);
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

        return res;
    }
}
