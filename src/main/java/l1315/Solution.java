package l1315;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> spec = new LinkedList<>();

        addToQueue(queue, root);

        int result = 0;

        while ((!queue.isEmpty()) || (!spec.isEmpty())) {
            Queue<TreeNode> q = queue;
            Queue<TreeNode> s = spec;
            queue = new LinkedList<>();
            spec = new LinkedList<>();

            for (TreeNode node : q) {
                if (match(node)) {
                    addToQueue(spec, node.left);
                    addToQueue(spec, node.right);
                } else {
                    addToQueue(queue, node.left);
                    addToQueue(queue, node.right);
                }
            }

            for (TreeNode node : s) {
                if (match(node)) {
                    result += addToQueue(spec, node.left);
                    result += addToQueue(spec, node.right);
                } else {
                    result += addToQueue(queue, node.left);
                    result += addToQueue(queue, node.right);
                }
            }
        }

        return result;
    }

    private boolean match(TreeNode node) {
        return node != null && node.val % 2 == 0;
    }

    private int addToQueue(Queue<TreeNode> queue, TreeNode node) {
        if (node != null) {
            queue.add(node);
            return node.val;
        }
        return 0;
    }
}
