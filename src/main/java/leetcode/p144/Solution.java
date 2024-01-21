package leetcode.p144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == null) {
                node = deque.removeLast();
                res.add(node.val);
            } else {
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                deque.addLast(node);
                deque.addLast(null);
            }
        }

        return res;
    }
}
