package l272;

import shared.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(Math.abs((long) o2 - target), Math.abs((long) o1 - target));
            }
        });

        travel(queue, root, target, k);

        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.addFirst(queue.remove());
        }

        return res;
    }

    private void travel(Queue<Integer> queue, TreeNode node, double target, int k) {
        if (node == null) {
            return;
        }

        if (queue.size() < k) {
            queue.add(node.val);
        } else {
            double d = Math.abs(node.val - target);
            if (d < Math.abs(queue.peek() - target)) {
                queue.remove();
                queue.add(node.val);
            }
        }
        travel(queue, node.left, target, k);
        travel(queue, node.right, target, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        new Solution().closestKValues(root, 2147483647.0, 1);
    }
}
