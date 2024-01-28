package leetcode.p437;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    private int res;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        travel(root, 0, targetSum, map);

        return res;
    }

    private void travel(TreeNode node, long pre, long target, Map<Long, Integer> map) {
        if (node == null) {
            return;
        }

        pre += node.val;
        if (map.containsKey(pre - target)) {
            res += map.get(pre - target);
        }
        map.compute(pre, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return ++v;
        });

        travel(node.left, pre, target, map);
        travel(node.right, pre, target, map);

        int v = map.get(pre);
        if (v == 1) {
            map.remove(pre);
        } else {
            map.put(pre, v - 1);
        }
    }
}
