package l103;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            List<TreeNode> list = queue;
            queue = new LinkedList<>();

            LinkedList<Integer> values = new LinkedList<>();
            for (TreeNode node : list) {
                if ((level & 1) == 0) {
                    values.addFirst(node.val);
                } else {
                    values.addLast(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(values);
            level++;
        }

        return res;
    }
}
