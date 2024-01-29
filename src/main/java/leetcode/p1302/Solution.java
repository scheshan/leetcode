package leetcode.p1302;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int cnt = 0, size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                cnt += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            res = cnt;
        }

        return res;
    }
}
