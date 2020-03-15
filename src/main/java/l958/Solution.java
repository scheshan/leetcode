package l958;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isBreak = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (isBreak && node != null) {
                return false;
            }

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                isBreak = true;
            }
        }

        return true;
    }
}
