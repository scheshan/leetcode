package leetcode.p1609;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            boolean odd = (level & 1) == 1;
            int pre = odd ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if (odd) {
                    if ((node.val & 1) == 1) {
                        return false;
                    }
                    if (node.val >= pre) {
                        return false;
                    }
                } else {
                    if ((node.val & 1) == 0) {
                        return false;
                    }
                    if (node.val <= pre) {
                        return false;
                    }
                }
                pre = node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return true;
    }
}
