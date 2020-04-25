package l652;

import shared.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        dfs(root, map, res);
        return res;
    }

    private void dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return;
        }

        String str = format(node);
        int c = map.compute(str, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return ++v;
        });
        if (c == 2) {
            res.add(node);
        }

        dfs(node.left, map, res);
        dfs(node.right, map, res);
    }

    private String format(TreeNode node) {
        if (node == null) {
            return "null";
        }

        return node.val + "," + format(node.left) + "," + format(node.right);
    }
}
