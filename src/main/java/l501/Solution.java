package l501;

import shared.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private int max;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        travel(root, map);

        LinkedList<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.addFirst(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.removeFirst();
        }

        return result;
    }

    private void travel(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        map.compute(node.val, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            v++;
            max = Math.max(max, v);
            return v;
        });

        travel(node.left, map);
        travel(node.right, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        new Solution().findMode(root);
    }
}
