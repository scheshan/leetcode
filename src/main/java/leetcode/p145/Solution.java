package leetcode.p145;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode marker = new TreeNode(-1);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node == marker) {
                node = deque.removeLast();
                res.add(node.val);
            } else {
                deque.addLast(node);
                deque.addLast(marker);

                if (node.right != null) {
                    deque.addLast(node.right);
                }
                if(node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }

        return res;
    }
}
