package l199;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        boolean newLine = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                if (newLine) {
                    res.add(node.val);
                    newLine = false;
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            } else {
                newLine = true;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return res;
    }
}
