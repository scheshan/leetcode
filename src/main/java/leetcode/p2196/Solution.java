package leetcode.p2196;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] arr : descriptions) {
            TreeNode node = getNode(map, arr[0]);
            if (arr[2] == 1) {
                node.left = getNode(map, arr[1]);
            } else {
                node.right = getNode(map, arr[1]);
            }

            children.add(arr[1]);
        }

        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            if (!children.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private TreeNode getNode(Map<Integer, TreeNode> map, int val) {
        TreeNode node = map.get(val);
        if (node == null) {
            node = new TreeNode(val);
            map.put(val, node);
        }
        return node;
    }
}
