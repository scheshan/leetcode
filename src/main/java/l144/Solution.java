package l144;

import shared.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            result.add(node.val);

            if (node.right != null) {
                deque.addFirst(node.right);
            }
            if (node.left != null) {
                deque.addFirst(node.left);
            }
        }

        return result;
    }
}
