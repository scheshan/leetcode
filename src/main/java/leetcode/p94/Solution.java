package leetcode.p94;

import common.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == null) {
                node = deque.removeLast();
                res.add(node.val);
            } else {
                if (node.right != null) {
                    deque.addLast(node.right);
                }

                deque.addLast(node);
                deque.addLast(null);

                if(node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }

        return res;
    }
}
