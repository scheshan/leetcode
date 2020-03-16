package m32_3;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            List<TreeNode> list = queue;
            queue = new LinkedList<>();

            LinkedList<Integer> level = new LinkedList<>();

            boolean isEven = (i & 1) == 0;

            for (TreeNode node : list) {
                if (isEven) {
                    level.addFirst(node.val);
                } else {
                    level.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);

            i++;
        }

        return result;
    }
}
