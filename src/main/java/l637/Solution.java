package l637;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> list = queue;
            queue = new LinkedList<>();

            double total = 0;
            int count = 0;
            for (TreeNode node : list) {
                total += node.val;
                count++;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(total / count);
        }

        return result;
    }
}
