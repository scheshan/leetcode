package leetcode.p272;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/25
 */
public class Solution {

    private class Item {
        int num;
        double delta;

        public Item(int num, double delta) {
            this.num = num;
            this.delta = delta;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Item> queue = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o2.delta, o1.delta);
        });

        dfs(root, target, k, queue);

        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(queue.remove().num);
        }
        return res;
    }

    private void dfs(TreeNode node, double target, int k, Queue<Item> queue) {
        if (node == null) {
            return;
        }
        double delta = Math.abs(target - node.val);
        if (queue.size() < k) {
            queue.add(new Item(node.val, delta));
        } else {
            if (delta < queue.peek().delta) {
                queue.remove();
                queue.add(new Item(node.val, delta));
            }
        }

        dfs(node.left, target, k, queue);
        dfs(node.right, target, k, queue);
    }
}
