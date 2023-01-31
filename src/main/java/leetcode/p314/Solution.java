package leetcode.p314;

import common.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    private int maxCol = Integer.MIN_VALUE;

    private int minCol = Integer.MAX_VALUE;

    private class Item {
        TreeNode node;
        int col;

        public Item(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfs(root, map);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item item = queue.remove();
                maxCol = Math.max(maxCol, item.col);
                minCol = Math.min(minCol, item.col);

                if (!map.containsKey(item.col)) {
                    map.put(item.col, new ArrayList<>());
                }
                map.get(item.col).add(item.node.val);

                if (item.node.left != null) {
                    queue.add(new Item(item.node.left, item.col - 1));
                }
                if (item.node.right != null) {
                    queue.add(new Item(item.node.right, item.col + 1));
                }
            }
        }
    }
}
