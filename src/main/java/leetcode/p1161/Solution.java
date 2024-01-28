package leetcode.p1161;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, res = 0, cur = 0, total = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            cur++;
            total = 0;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                total += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (total > max) {
                max = total;
                res = cur;
            }
        }

        return res;
    }
}
