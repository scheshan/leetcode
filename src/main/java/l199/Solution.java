package l199;

import shared.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            Deque<TreeNode> list = deque;
            deque = new LinkedList<>();

            result.add(list.peekLast().val);
            while (!list.isEmpty()) {
                TreeNode node = list.removeFirst();

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }

        return result;
    }
}
